package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.repository.AdmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class AdmService {

    @Autowired
    final AdmRepository AdmRep;

    public AdmService(AdmRepository admRep) {
        AdmRep = admRep;
    }


    @Transactional(rollbackFor = Exception.class)
    public void createAdm(final Adm adm){

        Assert.isTrue(adm.getUserAdm().equals("001AdmUser100") && adm.getSenhaAdm().equals("333AdminPassword777") || adm.getUserAdm().equals("TesteADM02") && adm.getSenhaAdm().equals("SENHA123")
                ,"Nome ou Senha Invalidos para Administrador");



        Assert.isTrue(! adm.getUserAdm().equals(""), "Adm não pode ser nulo");
        Assert.isTrue( adm.getUserAdm().length() <= 25, "Deve conter até 25 caracteres");

        Assert.isTrue( !adm.getSenhaAdm().equals(""), "Senha não pode ser nulo");
        Assert.isTrue(adm.getSenhaAdm().length() <= 20, "Senha deve conter até 20 caracteres");

        Assert.isTrue(!adm.getTelefone().equals(""), "Telefone não pode ser nulo");

        Assert.isTrue(adm.getTelefone().length() <= 40, "Telefone deve ter até 40 caracteres");

        Assert.isTrue(!adm.getEmail().equals(""), "E-mail não pode ser nulo");
        Assert.isTrue(adm.getEmail().length() <= 50, "E-mail deve ter até 50 caracteres");

        this.AdmRep.save(adm);


    }




}
