package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.entity.Usuario;
import br.com.Sublimoon.PI.repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping (value = "/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Usuario usuario = this.usuarioRepository.findById(id).orElse(null);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> Lista(){
        return ResponseEntity.ok(this.usuarioRepository.findAll());

    }


    @PostMapping
    public ResponseEntity <?> cadastrarUsuario(@RequestBody final Usuario usuario){
        try {
            this.admRepository.save(usuario);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarUsuario(@RequestParam("id") final Long id, @RequestBody final Usuario usuario){
        try {
            final Usuario usuario1 = this.usuarioRepository.findById(id).orElse(null);

            if (usuario1 == null || usuario1.getId().equals(usuario1.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.usuarioRepository.save(usuario);
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
    public void deletaUsuario(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }



}