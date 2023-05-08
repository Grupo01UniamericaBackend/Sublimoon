package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Favorito;
import br.com.Sublimoon.PI.repository.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @DeleteMapping("delete/{id}")
    public void deletaIdFavorito(@PathVariable Long id){
        favoritosRepository.deleteById(id);
    }

}