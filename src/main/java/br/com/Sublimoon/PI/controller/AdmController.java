package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.DTO.AdmDTO;
import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.repository.AdmRepository;
import br.com.Sublimoon.PI.repository.ConfigRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import br.com.Sublimoon.PI.service.AdmService;

@Controller
@RequestMapping (value = "/api/adm")
public class AdmController {

    @Autowired
     private AdmRepository admRep;

    @Autowired
     private AdmService admServ;
    @Autowired
    private ConfigRepository configRepository;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Adm adm = this.admRep.findById(id).orElse(null);
        return ResponseEntity.ok(adm);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> Lista() {
        return ResponseEntity.ok(this.admRep.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrarAdm(@RequestBody final AdmDTO adm) {
        try {

            this.admServ.createAdm(adm);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAdm(@PathVariable("id")Long id, @RequestBody final AdmDTO adm) {
        try {
            final Adm adm1 = this.admRep.findById(id).orElse(null);

            if (adm1 == null) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            this.admServ.createAdm(adm);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }  catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaAdm(@PathVariable Long id) {
        try {

            this.admServ.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }

    }


}