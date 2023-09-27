package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.DTO.PedidoDTO;
import br.com.sublimoon.pi.repository.PedidoRepository;
import br.com.sublimoon.pi.service.PedidoService;
import br.com.sublimoon.pi.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity <?> cadastrarPedido(@RequestBody final PedidoDTO pedidoDTO){
        try {
            pedidoService.verificarPedido(pedidoDTO);
            return ResponseEntity.ok("Pedido cadastrado com sucesso!!");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFavorito(@PathVariable("id") final Long id,@RequestBody Pedido pedido) {
        try {
            pedidoService.editarpedido(pedido);
            final Pedido pedido1 =this.pedidoRep.findById(id).orElse(null);

            if (pedido1 == null || !pedido1.getId().equals(pedido1.getId())){
                throw new RuntimeException("Nao foi possivel indentificar o Pedido informado");
            }
            return ResponseEntity.ok("Pedido editado no estoque com Sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError()
                    .body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
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
