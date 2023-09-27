package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.dto.AvaliacaoDTO;
import br.com.sublimoon.pi.entity.Avaliacao;
import br.com.sublimoon.pi.repository.AvaliacaoRepository;
import br.com.sublimoon.pi.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private AvaliacaoService avaliacaoServ;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Avaliacao avaliacao = this.avaliacaoRepository.findById(id).orElse(null);
        return ResponseEntity.ok(avaliacao);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> lista() {
        return ResponseEntity.ok(this.avaliacaoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrarAvaliacao(@RequestBody final AvaliacaoDTO avaliacaoDTO) {
        try {
                avaliacaoServ.createAvaliacao(avaliacaoDTO);
            return ResponseEntity.ok("Avaliado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAvaliacao(@PathVariable(value = "id") final Long id, @RequestBody final Avaliacao avaliacao) {
        try {
            avaliacaoServ.atualizaAvaliacao(avaliacao);
            final Avaliacao avaliacao1 = this.avaliacaoRepository.findById(id).orElse(null);

            if (avaliacao1 == null || !avaliacao1.getId().equals(avaliacao.getId())){
                throw new RuntimeException("Nao foi possivel identificar o registo informado");
            }
            return ResponseEntity.ok("Produto editado no estoque com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaAvaliacao(@PathVariable Long id) {

        try {

            avaliacaoServ.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }



    }


}
