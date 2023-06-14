package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import br.com.Sublimoon.PI.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import br.com.Sublimoon.PI.entity.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRep;

    @Autowired
    ClienteService clienteSer;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")  Long id){
        final Cliente cliente = this.clienteRep.findById(id).orElse(null);
        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/lista")
    public ResponseEntity<?> Lista() {
        return ResponseEntity.ok(this.clienteRep.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Cliente cliente) {
        try {
            this.clienteSer.VerificarCliente(cliente);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Cliente cliente) {
        try {
            final Cliente cliente1 = this.clienteRep.findById(id).orElse(null);

            if (cliente1 == null || cliente1.getId().equals(cliente1.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.clienteRep.save(cliente);
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
        clienteRep.deleteById(id);
    }
}
