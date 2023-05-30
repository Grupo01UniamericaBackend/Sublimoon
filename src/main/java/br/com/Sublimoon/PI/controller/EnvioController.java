package br.com.Sublimoon.PI.controller;

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
    final EnvioRepository envioRepository;

    @Autowired
    final EnvioService envioService;

    public EnvioController(EnvioRepository envioRepository, EnvioService envioService) {
        this.envioRepository = envioRepository;
        this.envioService = envioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Envio envio = this.envioRepository.findById(id).orElse(null);
        return ResponseEntity.ok(envio);
    }

    @DeleteMapping("delete/{id}")
    public void deletaIdEnvio(@PathVariable Long id){
        envioRepository.deleteById(id);
    }

    @GetMapping("/listaEnvio")
    public ResponseEntity <?> ListaCompletaEnvio(){
        return ResponseEntity.ok(this.envioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastrarEnvio(@RequestBody final Envio envio){
        try {
            this.envioRepository.save(envio);
            return ResponseEntity.ok("Envio cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }
}