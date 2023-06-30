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
    FavoritoRepository favoritoRep;


    @Autowired
    FavoritoService favoritoService;


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

            if(favoritoNovo == null || !favoritoNovo.getId().equals(favoritoNovo.getId())){

                throw new RuntimeException("Nao foi possivel indentificar o registro informado");

            }
             BeanUtils.copyProperties(favorito, favoritoNovo, "id");
             favoritoService.Favoritar(favorito);

                 this.favoritoRep.save(favorito);
                return ResponseEntity.ok("Registro alterado com sucesso");

         } catch(Exception e){
             return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

         }

    }



    @DeleteMapping("delete/{id}")
    public void deletaIdFavorito(@PathVariable Long id){
        favoritoRep.deleteById(id);
    }

}