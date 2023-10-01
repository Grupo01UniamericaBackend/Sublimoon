package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.dto.AvaliacaoDTO;
import br.com.sublimoon.pi.entity.Avaliacao;
import br.com.sublimoon.pi.repository.AvaliacaoRepository;
import br.com.sublimoon.pi.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping(value = "/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private AvaliacaoService avaliacaoServ;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Avaliacao>> findById(@PathVariable("id") final Long id) {
         Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Avaliacao>> lista() {
        return ResponseEntity.ok(this.avaliacaoRepository.findAll());
    }


    @PostMapping
    public ResponseEntity<String> cadastrarAvaliacao(@RequestBody final AvaliacaoDTO avaliacaoDTO) {
        try {
                avaliacaoServ.createAvaliacao(avaliacaoDTO);
            return ResponseEntity.ok("Avaliado com sucesso");
        } catch (Exception e) {
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarAvaliacao(@PathVariable(value = "id") final Long id, @RequestBody final Avaliacao avaliacao) {
        try {
            avaliacaoServ.atualizaAvaliacao(id, avaliacao);

            return ResponseEntity.ok("Produto editado no estoque com Sucesso");
        }
        catch (RuntimeException e){
            String errorMessage = getErrorMessage(e);
            return ResponseEntity.internalServerError().body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletaAvaliacao(@PathVariable Long id) {

        try {

            avaliacaoServ.delete(id);
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
