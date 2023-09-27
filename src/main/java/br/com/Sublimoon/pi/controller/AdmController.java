package br.com.Sublimoon.pi.controller;

import br.com.Sublimoon.pi.DTO.AdmDTO;
import br.com.Sublimoon.pi.entity.Adm;
import br.com.Sublimoon.pi.repository.AdmRepository;
import br.com.Sublimoon.pi.repository.ConfigRepository;
import br.com.Sublimoon.pi.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> lista() {
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
    public ResponseEntity<?> editarAdm(@PathVariable("id") final Long id, @RequestBody final Adm adm) {
            try {
                admServ.editaADM(adm);
                final Adm adm1 = this.admRep.findById(id).orElse(null);

                if (adm1 == null || !adm1.getId().equals(adm.getId())){
                    throw new RuntimeException("Não foi possível identificar o ADM informado");
                }
                return ResponseEntity.ok("ADM editado com sucesso");
            }
            catch (DataIntegrityViolationException e){
                return ResponseEntity.internalServerError()
                        .body("Error: " + e.getCause().getCause().getMessage());
            }
            catch (RuntimeException e){
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