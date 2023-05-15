package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Avaliacao;
import br.com.Sublimoon.PI.controller.AvaliacaoController;
import br.com.Sublimoon.PI.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository AvaliacaoRep;

    @Transactional(rollbackFor = Exception.class)
    public void createAvaliacao(final Avaliacao avaliacao){

    

    }

}
