package br.com.Sublimoon.PI.controller;


import br.com.Sublimoon.PI.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataIntegrityViolationException;
import br.com.Sublimoon.PI.entity.Produto;



@Controller
@RequestMapping(value = "/api/produto")
public class ProdutoController {

    @Autowired
    final ProdutosRepository produtoRepository;

    @Autowired
    final ProdutosService produtosService;

    public ProdutoController(ProdutosRepository produtoRepository, ProdutosService produtosService) {
        this.produtoRepository = produtoRepository;
        this.produtosService = produtosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Produto produto = this.produtoRepository.findById(id).orElse(null);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> Lista(){
        return ResponseEntity.ok(this.produtoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity <?> cadastrar(@RequestBody final Produto produto){
        try {
            this.produtoRepository.save(produto);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Produto produto){
        try {
            final Produto produto1 = this.produtoRepository.findById(id).orElse(null);

            if (produto1 == null || produto1.getId().equals(produto1.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.produtoRepository.save(produto);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleta(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }


}

