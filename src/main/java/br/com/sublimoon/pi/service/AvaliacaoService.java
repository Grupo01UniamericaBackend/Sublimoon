package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.dto.AvaliacaoDTO;
import br.com.sublimoon.pi.entity.Avaliacao;
import br.com.sublimoon.pi.repository.AvaliacaoRepository;
import br.com.sublimoon.pi.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    final AvaliacaoRepository avaliacaoRep;

    @Autowired
    private ClienteRepository clienteRep;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRep) {
        this.avaliacaoRep = avaliacaoRep;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> createAvaliacao(final AvaliacaoDTO avaliacaoDTO){

        var avaliacao = new Avaliacao();
        BeanUtils.copyProperties(avaliacaoDTO,avaliacao);

    Assert.isTrue(avaliacao.getNota() != null,"Nota não pode ser nulo");

    Assert.isTrue(avaliacao.getComentario()!=null, "Comentario não pode ser nulo");
    Assert.isTrue(avaliacao.getComentario().length() <= 150, "Comentário deve conter até 150 caracteres");

    this.avaliacaoRep.save(avaliacao);

    return ResponseEntity.ok("Avaliação criada com sucesso!");

    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> atualizaAvaliacao(Long id, Avaliacao avaliacao){

    this.avaliacaoRep.save(avaliacao);

    return ResponseEntity.ok("Avaliação atualizada!");
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> delete(Long id){

        if(avaliacaoRep.getReferenceById(id).isAtivo()) {
            avaliacaoRep.getReferenceById(id).setAtivo(false);
        }
        avaliacaoRep.deleteById(id);

        return ResponseEntity.ok("Avaliação deletada com sucesso!");

    }

}
