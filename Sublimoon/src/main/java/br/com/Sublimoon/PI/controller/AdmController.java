package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.repository.AdmRepository;
import br.com.Sublimoon.PI.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping (value = "/api/adm")
public class AdmController {

    @Autowired
    AdmRepository admRepository;
    @Autowired
    AdmService admService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Adm adm = this.admRepository.findById(id).orElse(null);
        return ResponseEntity.ok(adm);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> Lista(){
        return ResponseEntity.ok(this.admRepository.findAll());

    }


    @PostMapping
    public ResponseEntity <?> cadastrarAdm(@RequestBody final Adm adm){
        try {
            this.admRepository.save(adm);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarAdm(@RequestParam("id") final Long id, @RequestBody final Adm adm){
        try {
            final Adm adm1 = this.admRepository.findById(id).orElse(null);

            if (adm1 == null || adm1.getId().equals(adm1.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.admRepository.save(adm);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deletaAdm(@PathVariable Long id){
        admRepository.deleteById(id);
    }



}