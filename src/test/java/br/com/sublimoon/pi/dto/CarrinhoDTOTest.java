package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Item;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CarrinhoDTOTest {

    private List<Item> itemList = new ArrayList<>();

    private Cliente cliente;

    CarrinhoDTO carrinho = new CarrinhoDTO(2,10,20,cliente,itemList);

    @Test
    void getQuantidade() {
        Assertions.assertEquals(2,carrinho.getQuantidade());
    }

    @Test
    void getDesconto() {
        Assertions.assertEquals(10,carrinho.getDesconto());
    }

    @Test
    void getSubTotal() {
        Assertions.assertEquals(20,carrinho.getSubTotal());
    }

    @Test
    void getCliente() {
        Assertions.assertEquals(null,cliente);
    }

    @Test
    void getItem() {
        List<Item>itens = new ArrayList<>();

        Assertions.assertEquals(itens,itemList);
    }

    @Test
    void setQuantidade() {
        carrinho.setQuantidade(3);
        Assertions.assertEquals(3,carrinho.getQuantidade());
    }

    @Test
    void setDesconto() {
        carrinho.setDesconto(20);
        Assertions.assertEquals(20,carrinho.getDesconto());
    }

    @Test
    void setSubTotal() {
        carrinho.setSubTotal(30);
        Assertions.assertEquals(30,carrinho.getSubTotal());
    }

    @Test
    void setCliente() {
        Cliente clienteFuncao = null;
        carrinho.setCliente(clienteFuncao);
        Assertions.assertEquals(cliente,clienteFuncao);
    }

    @Test
    void setItem() {
        List<Item> itemListFunc = new ArrayList<>();
        Assertions.assertEquals(itemListFunc,itemList);
    }

    @Test
    void testEquals() {
        CarrinhoDTO carrinho2 = new CarrinhoDTO(2,10,20,cliente,itemList);
        Assertions.assertEquals(carrinho2,carrinho);

    }

    @Test
    void canEqual() {
        CarrinhoDTO carrinho2 = new CarrinhoDTO(2,10,20,cliente,itemList);

        Assertions.assertTrue(carrinho.canEqual(carrinho2));

    }

    @Test
    void testHashCode() {
        CarrinhoDTO carrinho2 = new CarrinhoDTO(2,10,20,cliente,itemList);
        CarrinhoDTO carrinho3 = new CarrinhoDTO(2,10,20,cliente,itemList);

        Assertions.assertEquals(carrinho2.hashCode(),carrinho3.hashCode());

    }

    @Test
    void testToString() {
        CarrinhoDTO carrinho4 = new CarrinhoDTO(2,10,20,cliente,itemList);

        Assertions.assertEquals(carrinho4.toString(),carrinho4.toString());
    }
}