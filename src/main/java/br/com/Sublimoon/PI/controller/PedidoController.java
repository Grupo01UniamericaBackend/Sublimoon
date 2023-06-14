package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.repository.PedidoRepository;
import br.com.Sublimoon.PI.service.PedidoService;
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
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Pedido pedido = this.pedidoRep.findById(id).orElse(null);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("delete/{id}")
    public void deletaPedido(@PathVariable Long id){
        pedidoRep.deleteById(id);
    }

    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompletaPedido(){
        return ResponseEntity.ok(this.pedidoRep.findAll());
    }

    @PostMapping
    public ResponseEntity <?> cadastrarPedido(@RequestBody final Pedido pedido){
        try {
            this.pedidoRep.save(pedido);
            return ResponseEntity.ok("Pedido cadastrado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }

}
