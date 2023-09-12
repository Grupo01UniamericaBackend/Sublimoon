package br.com.Sublimoon.PI.controller;
import br.com.Sublimoon.PI.DTO.EnvioDTO;
import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.repository.EnvioRepository;
import br.com.Sublimoon.PI.service.EnvioService;
import org.springframework.beans.BeanUtils;
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
    private EnvioRepository envioRepository;


    @Autowired
    private EnvioService envioServ;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Envio envio = this.envioRepository.findById(id).orElse(null);
        return ResponseEntity.ok(envio);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompletaEnvio(){
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
    public ResponseEntity<?> editar(@PathVariable("id") final Long id, @RequestBody final EnvioDTO envio) {
        try {
            final Envio envio1 = this.envioRepository.findById(id).orElse(null);

            if (envio1 == null || !envio1.getId().equals(envio.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            final Envio envioNovo = envioRepository.getById(id);
            BeanUtils.copyProperties(envio, envioNovo, "id","cadastro", "ativo");

            this.envioServ.validaEnvio(envioNovo);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");

        }  catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaIdEnvio(@PathVariable Long id){
        try {

            envioServ.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

}
