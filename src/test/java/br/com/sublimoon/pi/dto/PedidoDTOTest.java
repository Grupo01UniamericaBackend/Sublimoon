package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Carrinho;
import br.com.sublimoon.pi.entity.Envio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PedidoDTOTest {
    Carrinho carrinho = new Carrinho();
    Envio envio = new Envio();
    PedidoDTO pedidoDTO = new PedidoDTO(10,"cartao","vila b","63463",carrinho,envio);

    @Test
    void getTotal() {
        Assertions.assertEquals(10,pedidoDTO.getTotal());
    }

    @Test
    void getPagamento() {
        Assertions.assertEquals("cartao",pedidoDTO.getPagamento());
    }

    @Test
    void getEndereco() {
        Assertions.assertEquals("vila b",pedidoDTO.getEndereco());
    }

    @Test
    void getCep() {
        Assertions.assertEquals("63463",pedidoDTO.getCep());
    }

    @Test
    void getCarrinho() {
        Assertions.assertEquals(carrinho,pedidoDTO.getCarrinho());
    }

    @Test
    void getEnvio() {
        Assertions.assertEquals(envio,pedidoDTO.getEnvio());
    }

    @Test
    void setTotal() {
        pedidoDTO.setTotal(15);
        Assertions.assertEquals(15,pedidoDTO.getTotal());
    }

    @Test
    void setPagamento() {
        pedidoDTO.setPagamento("dinheiro");
        Assertions.assertEquals("dinheiro",pedidoDTO.getPagamento());
    }

    @Test
    void setEndereco() {
        pedidoDTO.setEndereco("vila a");
        Assertions.assertEquals("vila a",pedidoDTO.getEndereco());
    }

    @Test
    void setCep() {
        pedidoDTO.setCep("4432");
        Assertions.assertEquals("4432",pedidoDTO.getCep());
    }

    @Test
    void setCarrinho() {
        pedidoDTO.setCarrinho(carrinho);
        Assertions.assertEquals(carrinho,pedidoDTO.getCarrinho());
    }

    @Test
    void setEnvio() {
        pedidoDTO.setEnvio(envio);
        Assertions.assertEquals(envio,pedidoDTO.getEnvio());
    }

    @Test
    void testEquals() {
        PedidoDTO pedidoDTO2 = new PedidoDTO(10,"cartao","vila b","63463",carrinho,envio);
        Assertions.assertEquals(pedidoDTO2,pedidoDTO);
    }

    @Test
    void canEqual() {
        PedidoDTO pedidoDTO2 = new PedidoDTO(10,"cartao","vila b","63463",carrinho,envio);
        Assertions.assertTrue(pedidoDTO2.canEqual(pedidoDTO));
    }

    @Test
    void testHashCode() {
        PedidoDTO pedidoDTO2 = new PedidoDTO(10,"cartao","vila b","63463",carrinho,envio);
        Assertions.assertEquals(pedidoDTO2.hashCode(),pedidoDTO.hashCode());
    }

    @Test
    void testToString() {
        PedidoDTO pedidoDTO2 = new PedidoDTO(10,"cartao","vila b","63463",carrinho,envio);
        Assertions.assertEquals(pedidoDTO2.toString(),pedidoDTO.toString());
    }
}