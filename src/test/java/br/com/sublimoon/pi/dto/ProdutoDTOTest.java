package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Categoria;
import br.com.sublimoon.pi.entity.Cor;
import br.com.sublimoon.pi.entity.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProdutoDTOTest {

    ProdutoDTO produto = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
    @Test
    void getAndNome() {

        produto.setNome("copo");

        Assertions.assertEquals("copo", produto.getNome());
    }

    @Test
    void getAndCategoria() {

        produto.setCategoria(Categoria.COPOTERMICO);

        Assertions.assertEquals(Categoria.COPOTERMICO, produto.getCategoria());
    }

    @Test
    void getAndSetCor() {
        produto.setCor(Cor.AZUL);

        Assertions.assertEquals(Cor.AZUL, produto.getCor());
    }

    @Test
    void getAndSetDescricao() {

        produto.setDescricao("teste");

        Assertions.assertEquals("teste", produto.getDescricao());

    }

    @Test
    void getAndSetImagem() {
        produto.setImagem("png.png");

        Assertions.assertEquals("png.png", produto.getImagem());
    }

    @Test
    void getAndSetPreco() {
        produto.setPreco(10f);


        Assertions.assertEquals(10f, produto.getPreco());
    }

    @Test
    void getAndSetQuantidade() {
        produto.setQuantidade(1f);

        Assertions.assertEquals(1f, produto.getQuantidade());
    }

    @Test
    void getAndSetMediaAvaliacao() {
        produto.setMediaAvaliacao(2f);
        Assertions.assertEquals(2f, produto.getMediaAvaliacao());
    }

    @Test
    void getAndSetTamanho() {

        produto.setTamanho("12cm");

        Assertions.assertEquals("12cm", produto.getTamanho());
    }

    @Test
    void testEquals() {
        ProdutoDTO produto2 = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");

        Assertions.assertTrue(produto.equals(produto2));
    }

    @Test
    void canEqual() {
        ProdutoDTO produto2 = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");

        Assertions.assertTrue(produto2.canEqual(produto));
    }

    @Test
    void testHashCode() {
        ProdutoDTO produto2 = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Assertions.assertEquals(produto2.hashCode(), produto.hashCode());
    }

    @Test
    void testToString() {
        ProdutoDTO produto2 = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Assertions.assertEquals(produto2.toString(), produto.toString());
    }
}