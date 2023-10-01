package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.DTO.ProdutoDTO;
import br.com.sublimoon.pi.entity.Categoria;
import br.com.sublimoon.pi.entity.Produto;
import br.com.sublimoon.pi.repository.ProdutoRepository;
import br.com.sublimoon.pi.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRep;

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable("id") final Long id) {
        Optional<Produto> produto = this.produtoRep.findById(id);
        return ResponseEntity.ok(produto);
    }



    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Produto>> findByCategoria(@PathVariable("categoria") Categoria categoria) {

        return ResponseEntity.ok(produtoRep.findByCategoria(categoria));

    }



    @GetMapping("/lista")
    public ResponseEntity <List<Produto>> lista(){
        return ResponseEntity.ok(this.produtoRep.findAll());

    }

    @GetMapping("/favorito/lista")
    public ResponseEntity <List<Produto>> listaFavoritos(){
        return ResponseEntity.ok(this.produtoRep.findByAtivo(false));

    }

    @PostMapping
    public ResponseEntity <String> cadastrar(@RequestBody final ProdutoDTO produto){
        try {
            produtoService.cadastrar(produto);
            return ResponseEntity.ok("Produto Cadastrado com sucesso!!");
        }
        catch (Exception e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarProduto(@PathVariable("id") final Long id, @RequestBody final Produto produto){
        try {
            produtoService.atualizaProduto(produto);
            final Produto produto1 = this.produtoRep.findById(id).orElse(null);

            if (produto1 == null || !produto1.getId().equals(produto.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o Produto informado");
            }
            return ResponseEntity.ok("Produto editado no estoque com Sucesso");
        }
        catch (RuntimeException e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }

    }

    @PutMapping("/fav/{id}")
    public ResponseEntity<String> fav(@PathVariable("id") final Long id, @RequestBody final Produto produto){
        try {
            final Produto produto1 = this.produtoRep.findById(id).orElse(null);

            if (produto1 == null ){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            final Produto produtoNovo = produtoRep.getReferenceById(id);
            BeanUtils.copyProperties(produto, produtoNovo, "id","cadastro");

            this.produtoService.fav(produto);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (Exception e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Long id){

        try {

            produtoService.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        } catch (Exception e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    private String getErrorMessage(Exception e) {
        return "Error: " + e.getMessage();
    }



}

