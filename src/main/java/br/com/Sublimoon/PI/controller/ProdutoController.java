package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.DTO.ProdutoDTO;
import br.com.Sublimoon.PI.entity.*;
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
import br.com.Sublimoon.PI.entity.Categoria;

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



    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?> findByCategoria(@PathVariable("categoria") Categoria categoria) {

        return ResponseEntity.ok(produtoRep.findByCategoria(categoria));

    }



    @GetMapping("/lista")
    public ResponseEntity <?> Lista(){
        return ResponseEntity.ok(this.produtoRep.findAll());

    }

    @GetMapping("/favorito/lista")
    public ResponseEntity <?> ListaFavoritos(){
        return ResponseEntity.ok(this.produtoRep.findByAtivo(false));

    }


    @PostMapping
    public ResponseEntity <?> cadastrar(@RequestBody final ProdutoDTO produto){
        try {
            produtoService.cadastrar(produto);
            return ResponseEntity.ok("Produto Cadastrado com sucesso!!");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarProduto(@PathVariable("id") final Long id, @RequestBody final Produto produto){
        try {
            produtoService.atualizaProduto(produto);
            final Produto produto1 = this.produtoRep.findById(id).orElse(null);

            if (produto1 == null || !produto1.getId().equals(produto.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o Produto informado");
            }
            return ResponseEntity.ok("Produto editado no estoque com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }

    }

    @PutMapping("/fav/{id}")
    public ResponseEntity<?> fav(@PathVariable("id") final Long id, @RequestBody final Produto produto){
        try {
            final Produto produto1 = this.produtoRep.findById(id).orElse(null);

            if (produto1 == null ){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            final Produto produtoNovo = produtoRep.getById(id);
            BeanUtils.copyProperties(produto, produtoNovo, "id","cadastro");

            this.produtoService.fav(produto);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleta(@PathVariable Long id){

        try {

            produtoService.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }


}

