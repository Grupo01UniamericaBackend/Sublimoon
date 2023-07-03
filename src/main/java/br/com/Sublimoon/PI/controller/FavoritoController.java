package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.FavoritoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import br.com.Sublimoon.PI.service.FavoritoService;
import br.com.Sublimoon.PI.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.Sublimoon.PI.entity.Favorito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/favorito")
public class FavoritoController {

    @Autowired
    final FavoritoRepository favoritoRep;
    @Autowired
    final FavoritoService favoritoService;

    @Autowired
    final ProdutoService produtoService;

    @Autowired
    final  ProdutoRepository produtoRep;

    public FavoritoController(FavoritoRepository favoritoRep, FavoritoService favoritoService, ProdutoService produtoService, ProdutoRepository produtoRep) {
        this.favoritoRep = favoritoRep;
        this.favoritoService = favoritoService;
        this.produtoService = produtoService;
        this.produtoRep = produtoRep;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Favorito favorito = this.favoritoRep.findById(id).orElse(null);
        return ResponseEntity.ok(favorito);

    }

    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompletaFavoritos(){
        return ResponseEntity.ok(this.favoritoRep.findAll());
    }

    @PostMapping
    public ResponseEntity cadastraFavorito(@RequestBody final Favorito favorito){
        try {

            favoritoService.Favoritar(favorito);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFavorito(@PathVariable(value = "id") final Long id,@RequestBody Favorito favorito){
         try {
            final Favorito favoritoNovo = this.favoritoRep.findById(id).orElse(null);

            if(favoritoNovo == null ){

                throw new RuntimeException("Nao foi possivel indentificar o registro informado");

            }

            Favorito favoritoLista = favoritoRep.getById(id);
            // BeanUtils.copyProperties(favorito, favoritoNovo, "id","cadastro", "ativo");
             for(int i = 0; i < favorito.getProdutos().size(); i++) {
                 //favorito.getProdutos().get(i).setAtivo(true);
                 favoritoLista.getProdutos().add(favorito.getProdutos().get(i));
             }
            this.favoritoService.Favoritar(favoritoLista);
            return ResponseEntity.ok("Registro alterado com sucesso");

         } catch(Exception e){
             return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

         }

    }
    @GetMapping("favoritou/{id}/{produto}")
    public ResponseEntity<?> Favorito(@PathVariable (value = "id") final Long id, @PathVariable (value = "produto") final long idProduto) {
        try {
            Favorito favorito = favoritoRep.getById(id);
            List<Produto> favoritou = favorito.getProdutos();
            boolean IsTrue = false;


            for(int i = 0; i < favoritou.size(); i++){
                if(favoritou.get(i).getId() == idProduto){
                    favoritou.get(i).setAtivo(false);

                    favoritou.remove(i);
                    favorito.setProdutos(favoritou);
                    IsTrue = true;
                    favoritoRep.save(favorito);
                    return ResponseEntity.ok(IsTrue);
                }
            }

            return ResponseEntity.ok(IsTrue);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }



    @DeleteMapping("delete/{id}/{produto}")
    public ResponseEntity<?> deletaIdFavorito(@PathVariable (value = "id") final Long id, @PathVariable (value = "produto") final long idRemove) {
        try {
            Favorito favorito = favoritoRep.getById(id);
            List<Produto> remover = favorito.getProdutos();
            //Long idRemove = produto.getId();

            for(int i = 0; i < remover.size(); i++){
                if(remover.get(i).getId() == idRemove){
                    remover.get(i).setAtivo(false);

                    remover.remove(i);
                    favorito.setProdutos(remover);

                    favoritoRep.save(favorito);
                    return ResponseEntity.ok("Desativado ou excluído");
                }
            }

            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

}