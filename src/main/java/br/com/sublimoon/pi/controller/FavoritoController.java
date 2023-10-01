package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.dto.FavoritoDTO;
import br.com.sublimoon.pi.entity.Favorito;
import br.com.sublimoon.pi.entity.Produto;
import br.com.sublimoon.pi.repository.FavoritoRepository;
import br.com.sublimoon.pi.repository.ProdutoRepository;
import br.com.sublimoon.pi.service.FavoritoService;
import br.com.sublimoon.pi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Favorito>> findById(@PathVariable("id") final Long id){
        Optional<Favorito> favorito = this.favoritoRep.findById(id);
        return ResponseEntity.ok(favorito);
    }

    @GetMapping("/lista")
    public ResponseEntity <List<Favorito>> listaCompletaFavoritos(){
        return ResponseEntity.ok(this.favoritoRep.findAll());
    }

    @PostMapping
    public ResponseEntity <String> cadastraFavorito(@RequestBody final FavoritoDTO favoritoDTO){
        try {
                favoritoService.favoritar(favoritoDTO);
            return ResponseEntity.ok("Favoritado com sucesso!!!");
        }
        catch (DataIntegrityViolationException e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFavorito(@PathVariable(value = "id") final Long id,@RequestBody FavoritoDTO favorito){
        try {
            final Favorito favoritoNovo = this.favoritoRep.findById(id).orElse(null);

            if(favoritoNovo == null ){

                throw new RegistroNaoEncontradoException("Nao foi possivel indentificar o registro informado");

            }
            Favorito favoritoLista = favoritoRep.getReferenceById(id);

            for(int i = 0; i < favorito.getProdutos().size(); i++) {
                favoritoLista.getProdutos().add(favorito.getProdutos().get(i));
            }
            this.favoritoService.favoritar(favorito);
            return ResponseEntity.ok("Registro alterado com sucesso");

        } catch(Exception e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }

    }
    @GetMapping("favoritou/{id}")
    public ResponseEntity<Object> favorito(@PathVariable (value = "id") final Long id) {
        try {
            Favorito favorito = favoritoRep.getReferenceById(id);
            List<Produto>produtos = produtoRep.findAll();

            List<Produto> favoritou = favorito.getProdutos();
            long idProduto;
            long idFavorito;
            boolean isTrue = false;

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
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @DeleteMapping("delete/{id}/{produto}")
    public ResponseEntity<String> deletaIdFavorito(@PathVariable (value = "id") final Long id, @PathVariable (value = "produto") final long idRemove) {
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