package br.com.Sublimoon.PI.controller;

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
    final AdmRepository admRep;

    @Autowired
    final AdmService admServ;
    @Autowired
    final  ConfigRepository configRepository;

    public AdmController(AdmRepository admRep, AdmService admServ, ConfigRepository configRepository) {
        this.admRep = admRep;
        this.admServ = admServ;
        this.configRepository = configRepository;
    }


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
    public ResponseEntity<?> cadastrarAdm(@RequestBody final Adm adm) {
        try {
            Adm admExistente = admRep.findByTelefone(adm.getTelefone());
            Assert.isTrue(admExistente == null || admExistente.equals(adm.getTelefone()), "Telefone já cadastrado");
            Adm admExistente2 = admRep.findByEmail(adm.getEmail());
            Assert.isTrue(admExistente2 == null || admExistente2.equals(adm.getEmail()),"Email já cadastrado");

            this.admServ.createAdm(adm);

            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAdm(@PathVariable(value = "id")Long id, @RequestBody final Adm adm) {
        try {
            final Adm adm1 = this.admRep.findById(id).orElse(null);

            if (adm1 == null) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            findById(id);

            final Adm admNovo = admRep.getById(id);

            BeanUtils.copyProperties(adm, admNovo, "id","cadastro", "ativo");
            this.admServ.createAdm(admNovo);


           // this.admRep.save(adm);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deletaAdm(@PathVariable Long id) {

        findById(id);

        if(admRep.getById(id).isAtivo()){
            admRep.getById(id).setAtivo(false);
        }
        admRep.deleteById(id);

    }


}