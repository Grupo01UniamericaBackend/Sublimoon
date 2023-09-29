package br.com.Sublimoon.pi.controller;
import br.com.Sublimoon.pi.DTO.ConfigDTO;
import br.com.Sublimoon.pi.entity.Config;
import br.com.Sublimoon.pi.repository.ConfigRepository;
import br.com.Sublimoon.pi.service.ConfigService;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<?> lista() {
        return ResponseEntity.ok(this.configRep.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final ConfigDTO config) {
        try {
            Config config1 = new Config();
            BeanUtils.copyProperties(config,config1);
            this.configRep.save(config1);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable(value = "id") final Long id, @RequestBody final ConfigDTO config) {
        try {
            final Config config1 = this.configRep.findById(id).orElse(null);

            if (config1 == null) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            findById(id);

            final Config configNovo = configRep.getReferenceById(id);

            BeanUtils.copyProperties(config, configNovo, "id","cadastro", "ativo");

            this.configRep.save(configNovo);
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
        findById(id);
        if(configRep.getReferenceById(id).isAtivo()) {
            configRep.getReferenceById(id).setAtivo(false);
        }
        configRep.deleteById(id);
    }

}