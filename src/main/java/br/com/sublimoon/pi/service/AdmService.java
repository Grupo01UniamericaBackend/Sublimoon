package br.com.sublimoon.pi.service;
import br.com.sublimoon.pi.dto.AdmDTO;
import br.com.sublimoon.pi.entity.Adm;
import br.com.sublimoon.pi.repository.AdmRepository;
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
        adm.setSenhaAdm(senhaPreDefinida);
        adm.setUserAdm("AdmUserPred123");
        Assert.isTrue( adm.getUserAdm()!=null, "Adm não pode ser nulo");

        Assert.isTrue( adm.getUserAdm().length() <= 25, "Deve conter até 25 caracteres");

        Assert.isTrue( adm.getSenhaAdm()!=null, "Senha não pode ser nulo");

        this.admRep.save(adm);

        return ResponseEntity.ok("adm criado com sucesso!");

    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> editaADM(Adm adm){

        return ResponseEntity.ok("adm alterado com sucesso!");

    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<String> delete(Long id){

        this.admRep.deleteById(id);

        return ResponseEntity.ok("adm deletado com sucesso!");

    }




}
