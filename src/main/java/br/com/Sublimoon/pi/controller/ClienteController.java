package br.com.Sublimoon.pi.controller;

import br.com.Sublimoon.pi.DTO.ClienteDTO;
import br.com.Sublimoon.pi.entity.Cliente;
import br.com.Sublimoon.pi.repository.ClienteRepository;
import br.com.Sublimoon.pi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRep;

    @Autowired
    private ClienteService clienteSer;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable("id")  Long id){
        Optional<Cliente> cliente = this.clienteRep.findById(id);
        return ResponseEntity.ok(cliente);
    }
    @GetMapping("/lista")
    public ResponseEntity<List<Cliente>> lista() {
        return ResponseEntity.ok(this.clienteRep.findAll());

    }
    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody final Cliente cliente) {
        try {
            clienteSer.VerificarCliente(cliente);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@PathVariable(value = "id") final Long id, @RequestBody @Valid ClienteDTO cliente){
        try {

            final Cliente cliente1 = this.clienteRep.findById(id).orElse(null);

            if (cliente1 == null || !cliente1.getId().equals(cliente.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            Cliente clienteNovo = clienteRep.getReferenceById(id);
            BeanUtils.copyProperties(cliente, clienteNovo, "id", "cadastro", "ativo");

            clienteSer.VerificarCliente(clienteNovo);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Long id) {
        try {
            clienteSer.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }
    private String getErrorMessage(Exception e) {
        return "Error: " + e.getMessage();
    }

}
