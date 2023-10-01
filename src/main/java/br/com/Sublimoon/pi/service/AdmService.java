package br.com.Sublimoon.pi.service;
import br.com.Sublimoon.pi.DTO.AdmDTO;
import br.com.Sublimoon.pi.entity.Adm;
import br.com.Sublimoon.pi.repository.AdmRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class AdmService {

    @Autowired
     private AdmRepository admRep;

    public String hashPassword(String password){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> createAdm(final AdmDTO admDTO){

        var adm= new Adm();
        BeanUtils.copyProperties(admDTO, adm);

        String senhaPreDefinida = "123senhaAdm321"; // senha pré-definida
        String hashSenha = hashPassword(senhaPreDefinida);
        adm.setSenhaAdm(senhaPreDefinida);

        adm.setUserAdm("AdmUserPred123");
        Assert.isTrue(! adm.getUserAdm().equals(""), "Adm não pode ser nulo");

        Assert.isTrue( adm.getUserAdm().length() <= 25, "Deve conter até 25 caracteres");

        Assert.isTrue( !adm.getSenhaAdm().equals(""), "Senha não pode ser nulo");
       // Assert.isTrue(adm.getSenhaAdm().length() <= 40, "Senha deve conter até 20 caracteres");

        this.admRep.save(adm);

        return ResponseEntity.ok("adm criado com sucesso!");

    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> editaADM(Adm adm){
            final Adm admAtt=this.admRep.findById(adm.getId()).orElse(null);

        return ResponseEntity.ok("adm alterado com sucesso!");

    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> delete(Long id){

        this.admRep.deleteById(id);

        return ResponseEntity.ok("adm deletado com sucesso!");

    }




}
