package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AvaliacaoDTOTest {

    Cliente cliente = new Cliente(1L,"45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
    Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
    AvaliacaoDTO avaliacao = new AvaliacaoDTO(4.5F, "OK", cliente, produto);
    @Test
    void getAndSetNota() {

        avaliacao.setNota(3F);

        Assertions.assertEquals(3F, avaliacao.getNota());
    }

    @Test
    void getAndSetComentario() {
        avaliacao.setComentario("bom");

        Assertions.assertEquals("bom", avaliacao.getComentario());
    }

    @Test
    void getAndSetCliente() {
        Cliente cliente2 = new Cliente(1L,"45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");

        avaliacao.setCliente(cliente2);

        Assertions.assertEquals(cliente2, avaliacao.getCliente());
    }

    @Test
    void getAndSetProduto() {
        Produto produto2 = new Produto("Caneca", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");

        avaliacao.setProduto(produto2);
        Assertions.assertEquals(produto2, avaliacao.getProduto());
    }

    @Test
    void testEquals() {
        AvaliacaoDTO avaliacao2 = new AvaliacaoDTO(4.5F, "OK", cliente, produto);

        Assertions.assertTrue(avaliacao2.equals(avaliacao));
    }

    @Test
    void canEqual() {
        AvaliacaoDTO avaliacao2 = new AvaliacaoDTO(4.5F, "OK", cliente, produto);

        Assertions.assertTrue(avaliacao2.canEqual(avaliacao));
    }

    @Test
    void testHashCode() {
        AvaliacaoDTO avaliacao2 = new AvaliacaoDTO(4.5F, "OK", cliente, produto);

        Assertions.assertEquals(avaliacao2.hashCode(), avaliacao.hashCode());
    }

    @Test
    void testToString() {
        AvaliacaoDTO avaliacao2 = new AvaliacaoDTO(4.5F, "OK", cliente, produto);
        Assertions.assertEquals(avaliacao2.toString(), avaliacao.toString());
    }
}