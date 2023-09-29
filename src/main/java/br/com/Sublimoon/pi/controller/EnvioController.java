package br.com.Sublimoon.pi.controller;
import br.com.Sublimoon.pi.DTO.EnvioDTO;
import br.com.Sublimoon.pi.entity.Envio;
import br.com.Sublimoon.pi.repository.EnvioRepository;
import br.com.Sublimoon.pi.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/envio")
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;


    @Autowired
    private EnvioService envioServ;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Envio envio = this.envioRepository.findById(id).orElse(null);
        return ResponseEntity.ok(envio);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> listaCompletaEnvio(){
        return ResponseEntity.ok(this.envioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastrarEnvio(@RequestBody final EnvioDTO envioDTO){
        try {
            this.envioServ.validaEnvio(envioDTO);
            return ResponseEntity.ok("Envio cadastrado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") final Long id, @RequestBody final Envio envio) {
       try {
        envioServ.atualizaEnvio(envio);
        final Envio envio1 =this.envioRepository.findById(id).orElse(null);

        if (envio1 == null || !envio1.getId().equals(envio.getId())){
            throw new RuntimeException("Nao foi possivel identificar o envio informado");
        }
        return ResponseEntity.ok("Envio editado com sucesso!");
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
    public ResponseEntity<?> deletaIdEnvio(@PathVariable Long id){
        try {

            envioServ.delete(id);
            return ResponseEntity.ok("Envio excluido");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

}
