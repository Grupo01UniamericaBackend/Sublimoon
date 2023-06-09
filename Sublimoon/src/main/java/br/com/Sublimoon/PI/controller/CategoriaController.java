package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.repository.CategoriasRepository;
import br.com.Sublimoon.PI.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriasRepository categoriasRepository;
    @Autowired
    CategoriasService categoriasService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Categoria categoria = this.categoriasRepository.findById(id).orElse(null);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> Lista(){
        return ResponseEntity.ok(this.categoriasRepository.findAll());

    }


    @PostMapping
    public ResponseEntity <?> cadastrar(@RequestBody final Categoria categoria){
        try {
            this.categoriasRepository.save(categoria);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Categoria categoria){
        try {
            final Categoria categoria1 = this.categoriasRepository.findById(id).orElse(null);

            if (categoria1 == null || categoria1.getId().equals(categoria.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.categoriasRepository.save(categoria);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleta(@PathVariable Long id){
        categoriasRepository.deleteById(id);
    }
}