package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.DTO.ClienteDTO;
import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import br.com.Sublimoon.PI.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRep;

    @Autowired
    private ClienteService clienteSer;


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
    public ResponseEntity<?> cadastrar(@RequestBody final ClienteDTO cliente) {
        try {
            Cliente cliente1 = new Cliente();
            BeanUtils.copyProperties(cliente,cliente1);

            this.clienteSer.VerificarCliente(cliente1);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable(value = "id") final Long id, @RequestBody @Valid ClienteDTO cliente){
        try {

            final Cliente cliente1 = this.clienteRep.findById(id).orElse(null);

            if (cliente1 == null || !cliente1.getId().equals(cliente.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            Cliente clienteNovo = clienteRep.getById(id);
            BeanUtils.copyProperties(cliente, clienteNovo, "id", "cadastro", "ativo");


            clienteSer.VerificarCliente(clienteNovo);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error" + e .getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleta(@PathVariable Long id) {

        try {

            clienteSer.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }

    }
}
