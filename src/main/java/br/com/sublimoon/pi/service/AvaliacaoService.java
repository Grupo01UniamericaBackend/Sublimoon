package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.DTO.AvaliacaoDTO;
import br.com.sublimoon.pi.entity.Avaliacao;
import br.com.sublimoon.pi.repository.AvaliacaoRepository;
import br.com.sublimoon.pi.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRep;

    @Autowired
    private ClienteRepository clienteRep;

    @Transactional(rollbackFor = Exception.class)
    public void createAvaliacao(final AvaliacaoDTO avaliacaoDTO){

        var avaliacao = new Avaliacao();
        BeanUtils.copyProperties(avaliacaoDTO,avaliacao);

    Assert.isTrue(avaliacao.getNota() != null,"Nota não pode ser nulo");

    //Assert.isTrue(avaliacao.getCliente() != null,"Cliente não pode ser nulo");

    Assert.isTrue(!avaliacao.getComentario().equals(""), "Comentario não pode ser nulo");
    Assert.isTrue(avaliacao.getComentario().length() <= 150, "Comentário deve conter até 150 caracteres");

    this.avaliacaoRep.save(avaliacao);

    }

    @Transactional(rollbackFor = Exception.class)
    public void atualizaAvaliacao(Avaliacao avaliacao){
    final Avaliacao avaliacaoDTOatt = this.avaliacaoRep.findById(avaliacao.getId()).orElse(null);

    this.avaliacaoRep.save(avaliacao);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){

        if(avaliacaoRep.getReferenceById(id).isAtivo()) {
            avaliacaoRep.getReferenceById(id).setAtivo(false);
        }
        avaliacaoRep.deleteById(id);

    }

}
