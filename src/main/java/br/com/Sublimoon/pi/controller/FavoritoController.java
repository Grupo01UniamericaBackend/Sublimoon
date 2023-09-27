package br.com.Sublimoon.pi.controller;
import br.com.Sublimoon.pi.DTO.FavoritoDTO;
import br.com.Sublimoon.pi.entity.Favorito;
import br.com.Sublimoon.pi.entity.Produto;
import br.com.Sublimoon.pi.repository.FavoritoRepository;
import br.com.Sublimoon.pi.repository.ProdutoRepository;
import br.com.Sublimoon.pi.service.FavoritoService;
import br.com.Sublimoon.pi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    final ProdutoController produtoController;
    @Autowired
    final ProdutoService produtoService;

    @Autowired
    final ProdutoRepository produtoRep;

    public FavoritoController(FavoritoRepository favoritoRep, FavoritoService favoritoService, ProdutoController produtoController, ProdutoService produtoService, ProdutoRepository produtoRep) {
        this.favoritoRep = favoritoRep;
        this.favoritoService = favoritoService;
        this.produtoController = produtoController;
        this.produtoService = produtoService;
        this.produtoRep = produtoRep;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Favorito favorito = this.favoritoRep.findById(id).orElse(null);
        return ResponseEntity.ok(favorito);

    }

    @GetMapping("/lista")
    public ResponseEntity <?> listaCompletaFavoritos(){
        return ResponseEntity.ok(this.favoritoRep.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastraFavorito(@RequestBody final FavoritoDTO favoritoDTO){
        try {
                favoritoService.Favoritar(favoritoDTO);
            return ResponseEntity.ok("Favoritado com sucesso!!!");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFavorito(@PathVariable(value = "id") final Long id,@RequestBody FavoritoDTO favorito){
        try {
            final Favorito favoritoNovo = this.favoritoRep.findById(id).orElse(null);

            if(favoritoNovo == null ){

                throw new RuntimeException("Nao foi possivel indentificar o registro informado");

            }
            Favorito favoritoLista = favoritoRep.getReferenceById(id);

            for(int i = 0; i < favorito.getProdutos().size(); i++) {
                favoritoLista.getProdutos().add(favorito.getProdutos().get(i));
            }
            this.favoritoService.Favoritar(favorito);
            return ResponseEntity.ok("Registro alterado com sucesso");

        } catch(Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

        }

    }
    @GetMapping("favoritou/{id}")
    public ResponseEntity<?> Favorito(@PathVariable (value = "id") final Long id) {
        try {
            Favorito favorito = favoritoRep.getReferenceById(id);
            List<Produto>produtos = produtoRep.findAll();



            List<Produto> favoritou = favorito.getProdutos();
            long idProduto;
            long idFavorito;
            boolean IsTrue = false;

            for (Produto produto1 : produtos) {
                produto1.setAtivo(true);
                for (Produto produto2 : favoritou) {
                    if (produto1.equals(produto2)) {
                        produto1.setAtivo(false);
                    }

                }
            }


            return ResponseEntity.ok(produtos);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}/{produto}")
    public ResponseEntity<?> deletaIdFavorito(@PathVariable (value = "id") final Long id, @PathVariable (value = "produto") final long idRemove) {
        try {
            Favorito favorito = favoritoRep.getReferenceById(id);
            List<Produto> remover = favorito.getProdutos();
            //Long idRemove = produto.getId();

            for(int i = 0; i < remover.size(); i++){
                if(remover.get(i).getId() == idRemove){


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