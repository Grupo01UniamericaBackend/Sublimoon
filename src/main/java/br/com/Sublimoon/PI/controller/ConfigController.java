package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Config;
import br.com.Sublimoon.PI.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/configuracao")
public class ConfigController {

    @Autowired
    ConfigRepository configRep;

    @Autowired
    ConfigService configService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Config config = this.configRep.findById(id).orElse(null);
        return ResponseEntity.ok(config);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> Lista() {
        return ResponseEntity.ok(this.configRep.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Config config) {
        try {
            this.configRep.save(config);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Config config) {
        try {
            final Config config1 = this.configRep.findById(id).orElse(null);

            if (config1 == null || config1.getId().equals(config1.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.configRep.save(config);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleta(@PathVariable Long id) {
        configRep.deleteById(id);
    }

}
