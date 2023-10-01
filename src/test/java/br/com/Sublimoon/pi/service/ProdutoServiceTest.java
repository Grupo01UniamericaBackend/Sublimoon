package br.com.Sublimoon.pi.service;

import br.com.Sublimoon.pi.DTO.ProdutoDTO;
import br.com.Sublimoon.pi.entity.Categoria;
import br.com.Sublimoon.pi.entity.Cor;
import br.com.Sublimoon.pi.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ProdutoServiceTest {

    @MockBean
    ProdutoRepository produtoRepository;

    @Autowired
    private final ProdutoService produtoService = new ProdutoService();
    @Test
    void cadastrar() {
        ProdutoDTO produto = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        var produtoservice = produtoService.cadastrar(produto).getBody();

       // Assertions.assertEquals("produto cadastrado com sucesso!", produtoservice);
    }

    @Test
    void atualizaProduto() {
    }

    @Test
    void delete() {
    }

    @Test
    void fav() {
    }
}