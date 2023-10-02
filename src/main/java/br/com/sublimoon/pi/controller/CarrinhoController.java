package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.dto.CarrinhoDTO;
import br.com.sublimoon.pi.entity.Carrinho;
import br.com.sublimoon.pi.repository.CarrinhoRepository;
import br.com.sublimoon.pi.service.CarrinhoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    @Autowired
    private CarrinhoService carrinhoService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carrinho>> findById(@PathVariable("id") final Long id) {
        Optional<Carrinho> carrinho = this.carrinhoRepository.findById(id);
        return ResponseEntity.ok(carrinho);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Carrinho>> lista() {
        return ResponseEntity.ok(this.carrinhoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody final CarrinhoDTO carrinho) {
        try {
            Carrinho carrinho1 = new Carrinho();
            BeanUtils.copyProperties(carrinho,carrinho1);
            this.carrinhoService.createCarrinho(carrinho1);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: "+e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@PathVariable(value = "id") final Long id, @RequestBody final CarrinhoDTO carrinho) {
        try {
            final Carrinho carrinho1 = this.carrinhoRepository.findById(id).orElse(null);

            if (carrinho1 == null) {
                return ResponseEntity.internalServerError().body("Nao foi possivel indentificar o registro informado");
            }
            final Carrinho carrinhoNovo = carrinhoRepository.getReferenceById(id);

            BeanUtils.copyProperties(carrinho, carrinhoNovo, "id","cadastro", "ativo");

            this.carrinhoService.createCarrinho(carrinhoNovo);
            this.carrinhoService.addCarrinho(id,carrinhoNovo);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }  catch (Exception e) {
            return ResponseEntity.internalServerError().body("ERror: "+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleta(@PathVariable Long id) {

        try {
            carrinhoService.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("ERRor: "+ e.getMessage());
        }
    }


}
