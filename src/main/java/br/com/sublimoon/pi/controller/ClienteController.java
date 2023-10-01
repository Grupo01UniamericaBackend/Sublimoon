package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.ClienteDTO;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.repository.ClienteRepository;
import br.com.sublimoon.pi.service.ClienteService;
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
    public ResponseEntity<String> cadastrar(@RequestBody final ClienteDTO cliente) {
        try {
            clienteSer.verificarCliente(cliente);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (RuntimeException e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@PathVariable(value = "id") final Long id, @RequestBody @Valid ClienteDTO cliente){
        try {

            final Cliente cliente1 = this.clienteRep.findById(id).orElse(null);

            if (cliente1 == null || !cliente1.getId().equals(cliente.getId())) {
                throw new RegistroNaoEncontradoException("Nao foi possivel indentificar o registro informado");
            }

            Cliente clienteNovo = clienteRep.getReferenceById(id);
            BeanUtils.copyProperties(cliente, clienteNovo, "id", "cadastro", "ativo");

            ClienteDTO clienteDTO = new ClienteDTO();
            BeanUtils.copyProperties(clienteNovo, clienteDTO);

            clienteSer.verificarCliente(clienteDTO);
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

    public static class RegistroNaoEncontradoException extends RuntimeException {
        public RegistroNaoEncontradoException(String message) {
            super(message);
        }
    }

}
