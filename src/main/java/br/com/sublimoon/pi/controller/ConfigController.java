package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.DTO.ConfigDTO;
import br.com.sublimoon.pi.entity.Config;
import br.com.sublimoon.pi.repository.ConfigRepository;
import br.com.sublimoon.pi.service.ConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/configuracao")
public class ConfigController {

    @Autowired
    ConfigRepository configRep;
    @Autowired
    ConfigService configService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Config>> findById(@PathVariable("id") final Long id) {
        Optional <Config> config = this.configRep.findById(id);
        return ResponseEntity.ok(config);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Config>> lista() {
        return ResponseEntity.ok(this.configRep.findAll());

    }


    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody final ConfigDTO config) {
        try {
            Config config1 = new Config();
            BeanUtils.copyProperties(config,config1);
            this.configRep.save(config1);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (RuntimeException e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@PathVariable(value = "id") final Long id, @RequestBody final ConfigDTO config) {
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
        } catch (RuntimeException e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
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

    private String getErrorMessage(Exception e) {
        return "Error: " + e.getMessage();
    }

}
