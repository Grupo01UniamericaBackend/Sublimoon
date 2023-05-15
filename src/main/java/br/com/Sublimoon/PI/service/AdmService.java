package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.controller.AdmController;
import br.com.Sublimoon.PI.repository.AdmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class AdmService {

    @Autowired
    private AdmRepository AdmRep;


    @Transactional(rollbackFor = Exception.class)
    public void createAdm(final Adm adm){

        Assert.isTrue(! adm.getUserAdm().equals(""), "Adm não pode ser nulo");
        Assert.isTrue( adm.getUserAdm().length() <= 25, "Deve conter até 25 caracteres");

        Assert.isTrue( !adm.getSenhaAdm().equals(""), "Senha não pode ser nulo");
        Assert.isTrue(adm.getSenhaAdm().length() <= 20, "Senha deve conter até 20 caracteres");


    }

}
