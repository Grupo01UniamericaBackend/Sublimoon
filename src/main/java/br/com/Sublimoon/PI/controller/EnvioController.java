package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.repository.EnvioRepository;
import br.com.Sublimoon.PI.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.Sublimoon.PI.entity.Envio;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/envio")
public class EnvioController {

    @Autowired
    EnvioRepository envioRepository;


    @Autowired
    EnvioService envioServ;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Envio envio = this.envioRepository.findById(id).orElse(null);
        return ResponseEntity.ok(envio);
    }

    @GetMapping("/listaEnvio")
    public ResponseEntity <?> ListaCompletaEnvio(){
        return ResponseEntity.ok(this.envioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastrarEnvio(@RequestBody final Envio envio){
        try {
            this.envioServ.validaEnvio(envio);
            return ResponseEntity.ok("Envio cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable(value = "id") final Long id, @RequestBody final Envio envio) {
        try {
            final Envio envio1 = this.envioRepository.findById(id).orElse(null);

            if (envio1 == null || envio1.getId().equals(envio.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.envioRepository.save(envio);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
    @DeleteMapping("delete/{id}")
    public void deletaIdEnvio(@PathVariable Long id){
        envioRepository.deleteById(id);
    }

}
