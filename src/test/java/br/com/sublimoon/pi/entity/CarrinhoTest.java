package br.com.sublimoon.pi.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CarrinhoTest {


    Produto produto = new Produto(1L, "carro");
    Item item = new Item(1L, produto, 2, 20, 20, 20);

    List<Item> itens = new ArrayList<>();



    Cliente cliente = new Cliente(1L, "459123", "dwda@gm.com", "Joao", "odamd", "1204.41");

    Carrinho carrinho = new Carrinho(1L, 2, 10.00F, 20.00F, cliente, itens);



    @Test
    void getandSetQuantidade() {

        Carrinho carrinho = new Carrinho(1L, 2, 10.00F, 20.00F, cliente, itens);

        carrinho.setQuantidade(3);

        Assertions.assertEquals(3, carrinho.getQuantidade());
    }

    @Test
    void getDesconto() {
        carrinho.setDesconto(12f);

        Assertions.assertEquals(12f, carrinho.getDesconto());


    }

    @Test
    void getSubTotal() {

        carrinho.setSubTotal(58f);

        Assertions.assertEquals(58f, carrinho.getSubTotal());
    }

    @Test
    void getCliente() {
        Cliente cliente2 = new Cliente(2L, "459123", "email@email.com", "sla", "odamd", "1204.41");

        carrinho.setCliente(cliente2);

        Assertions.assertEquals(cliente2, carrinho.getCliente());
    }

    @Test
    void getandSetItem() {
        itens.add(item);
        Item item2 = new Item(2L, produto, 2, 20, 20, 20);
        itens.add(item2);

        carrinho.setItem(itens);

        Assertions.assertEquals(2, carrinho.getItem().size());
    }




}