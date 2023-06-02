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
    public void createAdm(Adm adm){

        Assert.isTrue(! adm.getUserAdm().equals(""), "Adm não pode ser nulo");
        Assert.isTrue( adm.getUserAdm().length() <= 25, "Deve conter até 25 caracteres");

        Assert.isTrue( !adm.getSenhaAdm().equals(""), "Senha não pode ser nulo");
        Assert.isTrue(adm.getSenhaAdm().length() <= 20, "Senha deve conter até 20 caracteres");

        Assert.isTrue(!adm.getTelefone().equals(""), "Telefone não pode ser nulo");
        Adm admExistente = AdmRep.findByTelefone(adm.getTelefone());
        Assert.isTrue(admExistente == null || admExistente.equals(adm.getTelefone()), "Telefone já cadastrado");
        Assert.isTrue(adm.getTelefone().length() <= 40, "Telefone deve ter até 40 caracteres");

        Assert.isTrue(!adm.getEmail().equals(""), "E-mail não pode ser nulo");
        Adm admExistente2 = AdmRep.findByEmail(adm.getEmail());
        Assert.isTrue(admExistente2 == null || admExistente2.equals(adm.getEmail()),"Email já cadastrado");
        Assert.isTrue(adm.getEmail().length() <= 50, "E-mail deve ter até 50 caracteres");



    }

    @Transactional(rollbackFor = Exception.class)
    public void DeleteById(Long id){


    }
}
