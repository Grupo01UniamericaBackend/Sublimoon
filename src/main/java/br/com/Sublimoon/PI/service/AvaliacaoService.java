package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Avaliacao;
import br.com.Sublimoon.PI.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository AvaliacaoRep;

    @Transactional(rollbackFor = Exception.class)
    public void createAvaliacao(final Avaliacao avaliacao){


    Assert.isTrue(avaliacao.getNota() != null,"Nota não pode ser nulo");


    Optional<Avaliacao> avaliacaoExistente = AvaliacaoRep.findById(avaliacao.getId());
    Assert.isTrue(avaliacaoExistente == null || avaliacaoExistente.equals(avaliacao.getId()), "Id já existente");



    Assert.isTrue(avaliacao.getCliente() != null,"Cliente não pode ser nulo");

    Assert.isTrue(!avaliacao.getComentario().equals(""), "Comentario não pode ser nulo");
    Assert.isTrue(avaliacao.getComentario().length() <= 150, "Comentário deve conter até 150 caracteres");

    this.AvaliacaoRep.save(avaliacao);


    }

}
