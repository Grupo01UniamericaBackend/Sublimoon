package br.com.Sublimoon.PI.controller;


import br.com.Sublimoon.PI.entity.Avaliacao;
import br.com.Sublimoon.PI.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.Sublimoon.PI.service.AvaliacaoService;

@Controller
@RequestMapping(value = "/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    AvaliacaoService avaliacaoServ;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Avaliacao avaliacao = this.avaliacaoRepository.findById(id).orElse(null);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> Lista() {
        return ResponseEntity.ok(this.avaliacaoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrarAvaliacao(@RequestBody final Avaliacao avaliacao) {
        try {
            this.avaliacaoServ.createAvaliacao(avaliacao);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarAvaliacao(@RequestParam("id") final Long id, @RequestBody final Avaliacao avaliacao) {
        try {
            final Avaliacao avaliacao1 = this.avaliacaoRepository.findById(id).orElse(null);

            if (avaliacao1 == null || avaliacao1.getId().equals(avaliacao1.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            this.avaliacaoRepository.save(avaliacao);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deletaAvaliacao(@PathVariable Long id) {
        avaliacaoRepository.deleteById(id);
    }


}
