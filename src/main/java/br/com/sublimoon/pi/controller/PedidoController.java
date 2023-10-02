package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.PedidoDTO;
import br.com.sublimoon.pi.entity.Pedido;
import br.com.sublimoon.pi.repository.PedidoRepository;
import br.com.sublimoon.pi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/api/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRep;


    @Autowired
    PedidoService pedidoService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> findById(@PathVariable("id") final Long id){
        Optional<Pedido> pedido = pedidoRep.findById(id);
        return ResponseEntity.ok(pedido);
    }


    @GetMapping("/lista")
    public ResponseEntity <List<Pedido>> listaCompletaPedido(){
        return ResponseEntity.ok(pedidoRep.findAll());
    }

    @PostMapping
    public ResponseEntity <String> cadastrarPedido(@RequestBody final PedidoDTO pedidoDTO){
        try {
            this.pedidoService.verificarPedido(pedidoDTO);
            return ResponseEntity.ok("Pedido cadastrado com sucesso!!");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error:" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFavorito(@PathVariable("id") final Long id,@RequestBody Pedido pedido) {
        try {
            pedidoService.editarpedido(pedido);
            final Pedido pedido1 =this.pedidoRep.findById(id).orElse(null);

            if (pedido1 == null || !pedido1.getId().equals(pedido1.getId())){
                return ResponseEntity.internalServerError().body("Nao foi possivel indentificar o registro informado");
            }
            return ResponseEntity.ok("Pedido editado no estoque com Sucesso");
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("ERROR: "+ e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletaPedido(@PathVariable Long id) {
        try {

            pedidoService.delete(id);
            return ResponseEntity.ok("Desativado ou excluído");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("ERror:" + e.getMessage());
        }
    }

}
