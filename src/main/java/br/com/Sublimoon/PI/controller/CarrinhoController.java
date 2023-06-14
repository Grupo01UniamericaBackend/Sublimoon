package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.repository.CarrinhoRepository;
import br.com.Sublimoon.PI.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoRepository carrinhoRepository;


    @Autowired
    CarrinhoService carrinhoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Carrinho carrinho = this.carrinhoRepository.findById(id).orElse(null);
        return ResponseEntity.ok(carrinho);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> Lista() {
        return ResponseEntity.ok(this.carrinhoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Carrinho carrinho) {
        try {
            this.carrinhoService.createCarrinho(carrinho);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Carrinho carrinho) {
        try {
            final Carrinho carrinho1 = this.carrinhoRepository.findById(id).orElse(null);

            if (carrinho1 == null || carrinho1.getId().equals(carrinho1.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.carrinhoRepository.save(carrinho);
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
        carrinhoRepository.deleteById(id);
    }


}
