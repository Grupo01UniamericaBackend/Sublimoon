package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.dto.ProdutoDTO;
import br.com.sublimoon.pi.entity.Categoria;
import br.com.sublimoon.pi.entity.Cor;
import br.com.sublimoon.pi.entity.Produto;
import br.com.sublimoon.pi.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class ProdutoServiceTest {

    @MockBean
    ProdutoRepository produtoRepository;


    @Autowired
    private final ProdutoService produtoService = new ProdutoService();

    @BeforeEach
    void injectAtualizar(){
        Optional<Produto> produto = Optional.of(new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM"));

        Mockito.when(produtoRepository.findById(1L)).thenReturn(produto);

    }
    @Test
    void cadastrar() {
        ProdutoDTO produto = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        var produtoservice = produtoService.cadastrar(produto).getBody();

        Assertions.assertEquals("produto cadastrado com sucesso!", produtoservice);
    }

    @Test
    void atualizaProduto() {
        Produto produto = new Produto(1L,"Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        var produtoservice = produtoService.atualizaProduto(produto).getBody();

        Assertions.assertEquals("produto atualizado com sucesso!", produtoservice);
    }

    @Test
    void delete() {

        var produtodoservice= produtoService.delete(1L).getBody();

        Assertions.assertEquals("produto deletado com sucesso!", produtodoservice);
    }

    @Test
    void fav() {
        Produto produto = new Produto(1L,"Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        var produtoservice = produtoService.fav(produto).getBody();

      //  Assertions.assertEquals("produto favoritado com sucesso!", produto);
    }
}