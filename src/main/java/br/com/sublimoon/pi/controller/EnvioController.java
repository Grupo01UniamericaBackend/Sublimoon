package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.dto.EnvioDTO;
import br.com.sublimoon.pi.entity.Envio;
import br.com.sublimoon.pi.repository.EnvioRepository;
import br.com.sublimoon.pi.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/api/envio")
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;


    @Autowired
    private EnvioService envioServ;

    @GetMapping("/{id}")

    public ResponseEntity<Optional<Envio>> findById(@PathVariable("id") final Long id){
        Optional<Envio> envio = this.envioRepository.findById(id);

        return ResponseEntity.ok(envio);
    }

    @GetMapping("/lista")
    public ResponseEntity <List<Envio>> listaCompletaEnvio(){
        return ResponseEntity.ok(this.envioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity <String> cadastrarEnvio(@RequestBody final EnvioDTO envioDTO){
        try {
            this.envioServ.validaEnvio(envioDTO);
            return ResponseEntity.ok("Envio cadastrado com sucesso");
        }
        catch (Exception e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@PathVariable("id") final Long id, @RequestBody final Envio envio) {
       try {
        envioServ.atualizaEnvio(envio);
        final Envio envio1 =this.envioRepository.findById(id).orElse(null);

        if (envio1 == null || !envio1.getId().equals(envio.getId())){
            throw new RegistroNaoEncontradoException("Nao foi possivel identificar o envio informado");
        }
        return ResponseEntity.ok("Envio editado com sucesso!");
       }
       catch (RuntimeException e){
           String errorMessage = getErrorMessage(e);
           return ResponseEntity.internalServerError().body(errorMessage);
       }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaIdEnvio(@PathVariable Long id){
        try {

            envioServ.delete(id);
            return ResponseEntity.ok("Envio excluido");
        }
        catch (Exception e){
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
