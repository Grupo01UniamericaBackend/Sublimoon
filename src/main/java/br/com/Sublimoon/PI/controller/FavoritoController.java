package br.com.Sublimoon.PI.controller;
import br.com.Sublimoon.PI.repository.ClienteRepository;
import br.com.Sublimoon.PI.repository.FavoritoRepository;
import br.com.Sublimoon.PI.repository.ProdutoRepository;
import br.com.Sublimoon.PI.service.FavoritoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.Sublimoon.PI.entity.Favorito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/favorito")
public class FavoritoController {

    @Autowired
    final FavoritoRepository favoritoRep;
    @Autowired
    final ClienteRepository clienteRepository;
    @Autowired
    final ProdutoRepository produtoRepository;
    @Autowired
    final FavoritoService favoritoService;

    public FavoritoController(FavoritoRepository favoritoRep, ClienteRepository clienteRepository, ProdutoRepository produtoRepository, FavoritoService favoritoService) {
        this.favoritoRep = favoritoRep;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.favoritoService = favoritoService;
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

            Assert.isTrue(produtoRepository.findById(favorito.getCliente().getId()).get()!= null, "Produto não encontrado!");
            Assert.isTrue(clienteRepository.findById(favorito.getCliente().getId()).get()!= null, "Cliente não encontrado!");
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
            findById(id);
             BeanUtils.copyProperties(favorito, favoritoNovo, "id","cadastro", "ativo");
             favoritoService.Favoritar(favoritoNovo);

                 this.favoritoService.Favoritar(favoritoNovo);
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