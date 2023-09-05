package br.com.Sublimoon.PI.controller;


import br.com.Sublimoon.PI.DTO.AvaliacaoDTO;
import br.com.Sublimoon.PI.entity.Adm;
import br.com.Sublimoon.PI.entity.Avaliacao;
import br.com.Sublimoon.PI.repository.AvaliacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.Sublimoon.PI.service.AvaliacaoService;
import br.com.Sublimoon.PI.entity.Cliente;

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
    public ResponseEntity<?> Lista() {
        return ResponseEntity.ok(this.avaliacaoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrarAvaliacao(@RequestBody final AvaliacaoDTO avaliacao) {
        try {
            Avaliacao avaliacao1 = new Avaliacao();
            BeanUtils.copyProperties(avaliacao,avaliacao1);
            this.avaliacaoServ.createAvaliacao(avaliacao1);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAvaliacao(@PathVariable(value = "id") final Long id, @RequestBody final AvaliacaoDTO avaliacao) {
        try {
            final Avaliacao avaliacao1 = this.avaliacaoRepository.findById(id).orElse(null);

            if (avaliacao1 == null || !avaliacao1.getId().equals(avaliacao.getId())) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }

            final Avaliacao avaliacaoNovo = avaliacaoRepository.getById(id);

            BeanUtils.copyProperties(avaliacao, avaliacaoNovo, "id","cadastro", "ativo");

            this.avaliacaoServ.createAvaliacao(avaliacaoNovo);

            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }  catch (RuntimeException e) {
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
