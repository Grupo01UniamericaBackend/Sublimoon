package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.AdmDTO;
import br.com.sublimoon.pi.entity.Adm;
import br.com.sublimoon.pi.repository.AdmRepository;
import br.com.sublimoon.pi.repository.ConfigRepository;
import br.com.sublimoon.pi.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Adm>> findById(@PathVariable("id")  Long id) {
        Optional<Adm> adm = this.admRep.findById(id);
        return ResponseEntity.ok(adm);
    }


    @GetMapping("/lista")
    public ResponseEntity<List<Adm>> lista() {
        return ResponseEntity.ok(this.admRep.findAll());
    }
    @PostMapping
    public ResponseEntity<String> cadastrarAdm(@RequestBody final AdmDTO adm) {
        try {

            this.admServ.createAdm(adm);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (RuntimeException e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarAdm(@PathVariable("id") final Long id, @RequestBody final Adm adm) {
            try {
                admServ.editaADM(adm);
                final Adm adm1 = this.admRep.findById(id).orElse(null);

                if (adm1 == null || !adm1.getId().equals(adm.getId())){
                    throw new RegistroNaoEncontradoException("Não foi possível identificar o ADM informado");
                }
                return ResponseEntity.ok("ADM editado com sucesso");
            }
            catch (RuntimeException e){
                String errorMessage = getErrorMessage(e);
                return ResponseEntity.internalServerError().body(errorMessage);
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaAdm(@PathVariable Long id) {
        try {

            this.admServ.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (RuntimeException e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    private String getErrorMessage(Exception e) {
        return "Error: " + e.getMessage();
    }


    public static class RegistroNaoEncontradoException extends RuntimeException {
        public RegistroNaoEncontradoException(String message) {
            super(message);
        }
    }

}