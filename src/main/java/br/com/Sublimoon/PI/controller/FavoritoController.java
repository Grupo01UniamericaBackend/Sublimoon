package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.repository.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.Sublimoon.PI.entity.Favorito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/favorito")
public class FavoritoController {

    @Autowired
    FavoritosRepository favoritosRepository;


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Favorito favorito = this.favoritosRepository.findById(id).orElse(null);
        return ResponseEntity.ok(favorito);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompletaFavoritos(){
        return ResponseEntity.ok(this.favoritosRepository.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastraFavorito(@RequestBody final Favorito favorito){
        try {
            this.favoritosRepository.save(favorito);
            return ResponseEntity.ok("Favorito adicionado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deletaIdFavorito(@PathVariable Long id){
        favoritosRepository.deleteById(id);
    }

}