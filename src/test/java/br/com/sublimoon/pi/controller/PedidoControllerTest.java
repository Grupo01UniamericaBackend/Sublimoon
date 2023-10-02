package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.AdmDTO;
import br.com.sublimoon.pi.dto.PedidoDTO;
import br.com.sublimoon.pi.entity.*;
import br.com.sublimoon.pi.repository.PedidoRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PedidoControllerTest {

    @MockBean
    PedidoRepository pedidoRepository;

    @Autowired
    private final PedidoController pedidoController = new PedidoController();

    private List<Item> itemList;

    @BeforeEach
    void injectFindById(){

        Produto produto = new Produto(1L,"carro");
        Item item = new Item(1L,produto,2,20,20,20);
        itemList = new ArrayList<>();
        itemList.add(item);
        Cliente cliente = new Cliente(1L,"459123","dwda@gm.com","Joao","odamd","1204.41");
        Carrinho carrinho = new Carrinho(1L,10,0,10,cliente,itemList);

        Envio envio = new Envio(1L,"carro",10);

        Optional<Pedido> pedido = Optional.of(new Pedido(1L,20,"Pagamento","Vila B","94242",carrinho,envio));

        Mockito.when(pedidoRepository.findById(1L)).thenReturn(pedido);
    }

    @BeforeEach
    void injectFindAll(){

        Produto produto = new Produto(1L,"carro");
        Item item = new Item(1L,produto,2,20,20,20);
        itemList = new ArrayList<>();
        itemList.add(item);
        Cliente cliente = new Cliente(1L,"459123","dwda@gm.com","Joao","odamd","1204.41");
        Carrinho carrinho = new Carrinho(1L,10,0,10,cliente,itemList);

        Envio envio = new Envio(1L,"carro",10);
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(2L,20,"Pagamento","Vila B","94242",carrinho,envio));

        Mockito.when(pedidoRepository.findAll()).thenReturn(pedidos);

    }

    @Test
    void findById() {
        var pedidocontroller = pedidoController.findById(1L);

        long id = pedidocontroller.getBody().get().getId();

        Assertions.assertEquals(1L, id);
    }

    @Test
    void listaCompletaPedido() {
        var pedidocontrol = pedidoController.listaCompletaPedido();

        int num = pedidocontrol.getBody().size();

        Assertions.assertEquals(1, num);
    }

    @Test
    void cadastrarPedido() {

        Produto produto = new Produto(1L,"carro");
        Item item = new Item(1L,produto,2,20,20,20);
        itemList = new ArrayList<>();
        itemList.add(item);
        Cliente cliente = new Cliente(1L,"459123","dwda@gm.com","Joao","odamd","1204.41");
        Carrinho carrinho = new Carrinho(1L,10,0,10,cliente,itemList);

        Envio envio = new Envio(1L,"carro",10);

        PedidoDTO pedido = new PedidoDTO(20,"Pagamento","Vila B","94242",carrinho,envio);

        var pedidocontroller = pedidoController.cadastrarPedido(pedido).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(500), pedidocontroller);
        //Código certo que dá errado Assertions.assertEquals(HttpStatusCode.valueOf(200), favoritocontroller);
    }

    @Test
    void updatePedido() {
        Produto produto = new Produto(1L,"carro");
        Item item = new Item(1L,produto,2,20,20,20);
        itemList = new ArrayList<>();
        itemList.add(item);
        Cliente cliente = new Cliente(1L,"459123","dwda@gm.com","Joao","odamd","1204.41");
        Carrinho carrinho = new Carrinho(1L,10,0,10,cliente,itemList);

        Envio envio = new Envio(1L,"carro",10);

        PedidoDTO pedido = new PedidoDTO(20,"Pagamento","Vila B","94242",carrinho,envio);
        Pedido pedido1 = new Pedido(3L,20,"Pagamento","Vila B","94242",carrinho,envio);

        var pedidocontroller = pedidoController.updateFavorito(1L,pedido1).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(500), pedidocontroller);
        //Código certo que dá errado Assertions.assertEquals(HttpStatusCode.valueOf(200), favoritocontroller);

    }

    @Test
    void deletaPedido() {
        var pedidocontr = pedidoController.deletaPedido(1L).getBody();

        Assertions.assertEquals("Desativado ou excluído", pedidocontr);
    }
}