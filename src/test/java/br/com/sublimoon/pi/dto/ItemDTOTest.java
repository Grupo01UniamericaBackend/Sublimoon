package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemDTOTest {
    Produto produto = new Produto();
    ItemDTO itemDTO = new ItemDTO(produto,2,10,5,10);

    @Test
    void getProduto() {
        Assertions.assertEquals(itemDTO.getProduto(),itemDTO.getProduto());
    }

    @Test
    void getQuantidade() {
        Assertions.assertEquals(2,itemDTO.getQuantidade());
    }

    @Test
    void getValor() {
        Assertions.assertEquals(10,itemDTO.getValor());
    }

    @Test
    void getValorUnit() {
        Assertions.assertEquals(5,itemDTO.getValorUnit());
    }

    @Test
    void getValorTotal() {
        Assertions.assertEquals(10,itemDTO.getValorTotal());
    }

    @Test
    void setId() {
        itemDTO.setId(2L);
        Assertions.assertEquals(2,itemDTO.getId());
    }

    @Test
    void setProduto() {
        itemDTO.setProduto(produto);
        Assertions.assertEquals(produto,itemDTO.getProduto());
    }

    @Test
    void setQuantidade() {
        itemDTO.setQuantidade(20);
        Assertions.assertEquals(20,itemDTO.getQuantidade());
    }

    @Test
    void setValor() {
        itemDTO.setValor(21);
        Assertions.assertEquals(21,itemDTO.getValor());
    }

    @Test
    void setValorUnit() {
        itemDTO.setValorUnit(3);
        Assertions.assertEquals(3,itemDTO.getValorUnit());
    }

    @Test
    void setValorTotal() {
        itemDTO.setValorTotal(30);
        Assertions.assertEquals(30,itemDTO.getValorTotal());
    }

    @Test
    void testEquals() {
        ItemDTO itemDTO1 = new ItemDTO(produto,2,10,5,10);
        Assertions.assertEquals(itemDTO1,itemDTO);
    }

    @Test
    void canEqual() {
        ItemDTO itemDTO1 = new ItemDTO(produto,2,10,5,10);
        Assertions.assertTrue(itemDTO1.canEqual(itemDTO));
    }

    @Test
    void testHashCode() {
        ItemDTO itemDTO1 = new ItemDTO(produto,2,10,5,10);
        Assertions.assertEquals(itemDTO1.hashCode(),itemDTO.hashCode());
    }

    @Test
    void testToString() {
        ItemDTO itemDTO1 = new ItemDTO(produto,2,10,5,10);
        Assertions.assertEquals(itemDTO1.toString(),itemDTO.toString());
    }


}