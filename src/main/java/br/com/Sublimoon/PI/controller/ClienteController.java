package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import br.com.Sublimoon.PI.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable(value = "id") final Long id, @RequestBody @Valid Cliente cliente)throws Exception {
        findById(id);

        Cliente clienteNovo = clienteRep.getById(id);
        BeanUtils.copyProperties(cliente, clienteNovo, "id");
        clienteSer.VerificarCliente(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteNovo);

    }

    @DeleteMapping("delete/{id}")
    public void deleta(@PathVariable Long id) {
        clienteRep.deleteById(id);
    }
}
