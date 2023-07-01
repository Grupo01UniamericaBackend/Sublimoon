package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Avaliacao;
import br.com.Sublimoon.PI.repository.AvaliacaoRepository;
import br.com.Sublimoon.PI.repository.ClienteRepository;
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
    public void createAvaliacao(final Avaliacao avaliacao){

    Assert.isTrue(avaliacao.getNota() != null,"Nota não pode ser nulo");

    //Assert.isTrue(avaliacao.getCliente() != null,"Cliente não pode ser nulo");

    Assert.isTrue(!avaliacao.getComentario().equals(""), "Comentario não pode ser nulo");
    Assert.isTrue(avaliacao.getComentario().length() <= 150, "Comentário deve conter até 150 caracteres");

    this.avaliacaoRep.save(avaliacao);

    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){

        if(avaliacaoRep.getById(id).isAtivo()) {
            avaliacaoRep.getById(id).setAtivo(false);
        }
        avaliacaoRep.deleteById(id);

    }

}
