package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.DTO.AdmDTO;
import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.repository.AdmRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service
public class AdmService {

    @Autowired
     private AdmRepository admRep;


    @Transactional(rollbackFor = Exception.class)
    public void createAdm(final AdmDTO admDTO){

        var adm= new Adm();
        BeanUtils.copyProperties(admDTO, adm);

        Assert.isTrue(adm.getUserAdm().equals("001AdmUser100") && adm.getSenhaAdm().equals("333AdminPassword777") || adm.getUserAdm().equals("TesteADM02") && adm.getSenhaAdm().equals("SENHA123")
                ,"Nome ou Senha Invalidos para Administrador");


        Adm admExistente = admRep.findByTelefone(adm.getTelefone());
        Assert.isTrue(admExistente == null || admExistente.equals(adm.getTelefone()), "Telefone já cadastrado");
        Adm admExistente2 = admRep.findByEmail(adm.getEmail());
        Assert.isTrue(admExistente2 == null || admExistente2.equals(adm.getEmail()),"Email já cadastrado");


        Assert.isTrue(! adm.getUserAdm().equals(""), "Adm não pode ser nulo");
        Assert.isTrue( adm.getUserAdm().length() <= 25, "Deve conter até 25 caracteres");

        Assert.isTrue( !adm.getSenhaAdm().equals(""), "Senha não pode ser nulo");
        Assert.isTrue(adm.getSenhaAdm().length() <= 20, "Senha deve conter até 20 caracteres");

        Assert.isTrue(!adm.getTelefone().equals(""), "Telefone não pode ser nulo");

        Assert.isTrue(adm.getTelefone().length() <= 40, "Telefone deve ter até 40 caracteres");

        Assert.isTrue(!adm.getEmail().equals(""), "E-mail não pode ser nulo");
        Assert.isTrue(adm.getEmail().length() <= 50, "E-mail deve ter até 50 caracteres");

        this.admRep.save(adm);


    }

    @Transactional(rollbackFor = Exception.class)
    public void editaADM(Adm adm){
            final Adm admAtt=this.admRep.findById(adm.getId()).orElse(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){

        this.admRep.deleteById(id);

    }




}
