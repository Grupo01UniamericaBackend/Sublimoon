package br.com.Sublimoon.pi.controller;
import br.com.Sublimoon.pi.DTO.CarrinhoDTO;
import br.com.Sublimoon.pi.entity.Carrinho;
import br.com.Sublimoon.pi.repository.CarrinhoRepository;
import br.com.Sublimoon.pi.service.CarrinhoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    @Autowired
    private CarrinhoService carrinhoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        final Carrinho carrinho = this.carrinhoRepository.findById(id).orElse(null);
        return ResponseEntity.ok(carrinho);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> lista() {
        return ResponseEntity.ok(this.carrinhoRepository.findAll());

    }


    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final CarrinhoDTO carrinho) {
        try {
            Carrinho carrinho1 = new Carrinho();
            BeanUtils.copyProperties(carrinho,carrinho1);
            this.carrinhoService.createCarrinho(carrinho1);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable(value = "id") final Long id, @RequestBody final CarrinhoDTO carrinho) {
        try {
            final Carrinho carrinho1 = this.carrinhoRepository.findById(id).orElse(null);

            if (carrinho1 == null) {
                throw new RuntimeException("Nao foi possivel indentificar o registro informado");
            }
            final Carrinho carrinhoNovo = carrinhoRepository.getReferenceById(id);

            BeanUtils.copyProperties(carrinho, carrinhoNovo, "id","cadastro", "ativo");

            this.carrinhoService.createCarrinho(carrinhoNovo);
            this.carrinhoService.addCarrinho(id,carrinhoNovo);
            return ResponseEntity.ok("Registro Cadastrado com Sucesso");
        }  catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleta(@PathVariable Long id) {

        try {

            carrinhoService.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }


    }


}
