package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.service.ProdutoService;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.dao.DataIntegrityViolationException;
import br.com.Sublimoon.PI.entity.Produto;



@Controller
@RequestMapping(value = "/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRep;

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Produto produto = this.produtoRep.findById(id).orElse(null);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> Lista(){
        return ResponseEntity.ok(this.produtoRep.findAll());

    }


    @PostMapping
    public ResponseEntity <?> cadastrar(@RequestBody final Produto produto, final Categoria categoria){
        try {
            Produto produtoExistente = produtoRep.findByNome(produto.getNome());
            Assert.isTrue(produtoExistente == null || produtoExistente.equals(produto),"Nome já cadastrado!");

            produtoService.cadastrar(produto);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarProduto(@RequestParam("id") final Long id, @RequestBody final Produto produto){
        try {
            final Produto produto1 = this.produtoRep.findById(id).orElse(null);

            if (produto1 == null ){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            findById(id);

            final Produto produtoNovo = produtoRep.getById(id);

            BeanUtils.copyProperties(produto, produtoNovo, "id","cadastro", "ativo");
            this.produtoService.cadastrar(produtoNovo);
            this.produtoRep.save(produto);
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
        findById(id);

        if(produtoRep.getById(id).isAtivo()){
            produtoRep.getById(id).setAtivo(false);
        }
        produtoRep.deleteById(id);
    }


}

