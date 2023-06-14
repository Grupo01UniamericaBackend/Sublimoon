package br.com.Sublimoon.PI.controller;
import br.com.Sublimoon.PI.repository.FavoritoRepository;
import br.com.Sublimoon.PI.service.FavoritoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    FavoritoRepository favoritosRep;


    @Autowired
    FavoritoService favoritoService;


    @GetMapping("/{id}")

        public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Favorito favorito = this.favoritosRep.findById(id).orElse(null);
        return ResponseEntity.ok(favorito);

    }

    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompletaFavoritos(){
        return ResponseEntity.ok(this.favoritosRep.findAll());
    }

    @PostMapping
    public ResponseEntity cadastraFavorito(@RequestBody final Favorito favorito){
        try {
            this.favoritosRep.save(favorito);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFavorito(@PathVariable(value = "id")Long id,@RequestBody @Valid Favorito favorito)throws Exception{
        findById(id);

        Favorito favoritoNovo = favoritosRep.getById(id);

        BeanUtils.copyProperties(favorito, favoritoNovo);
        favoritoService.Favoritar(favorito);
        return ResponseEntity.status(HttpStatus.OK).body(favoritoNovo);
    }



    @DeleteMapping("delete/{id}")
    public void deletaIdFavorito(@PathVariable Long id){
        favoritosRep.deleteById(id);
    }

}