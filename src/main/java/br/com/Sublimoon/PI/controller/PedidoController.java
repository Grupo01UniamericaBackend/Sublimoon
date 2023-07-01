package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Favorito;
import br.com.Sublimoon.PI.repository.PedidoRepository;

import br.com.Sublimoon.PI.service.PedidoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.Sublimoon.PI.entity.Pedido;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/api/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRep;


    @Autowired
    PedidoService pedidoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Pedido pedido = pedidoRep.findById(id).orElse(null);
        return ResponseEntity.ok(pedido);
    }


    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompletaPedido(){
        return ResponseEntity.ok(pedidoRep.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastrarPedido(@RequestBody final Pedido pedido){
        try {
            pedidoService.verificarPedido(pedido);
            return ResponseEntity.ok("Pedido cadastrado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFavorito(@PathVariable("id") final Long id,@RequestBody Pedido pedido){
        try {
            final Pedido pedido1 = this.pedidoRep.findById(id).orElse(null);

            if(pedido1 == null ){

                throw new RuntimeException("Nao foi possivel indentificar o registro informado");

            }


            BeanUtils.copyProperties(pedido, pedido1, "id","cadastro", "ativo");

            this.pedidoService.verificarPedido(pedido);
            return ResponseEntity.ok("Registro alterado com sucesso");

        } catch(Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());

        }

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletaPedido(@PathVariable Long id) {
        try {

            pedidoService.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

}
