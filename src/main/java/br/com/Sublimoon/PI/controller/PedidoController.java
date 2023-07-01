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
    public ResponseEntity<?> findById(@PathVariable("id") final Long id){
        final Pedido pedido = pedidoRep.findById(id).orElse(null);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("delete/{id}")
    public void deletaPedido(@PathVariable Long id){
        findById(id);
        if(pedidoRep.getById(id).isAtivo()){
            pedidoRep.getById(id).setAtivo(false);
        }
        pedidoRep.deleteById(id);
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
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
    }


}
