package br.com.Sublimoon.pi.controller;

import br.com.Sublimoon.pi.DTO.ProdutoDTO;
import br.com.Sublimoon.pi.entity.Categoria;
import br.com.Sublimoon.pi.entity.Cor;
import br.com.Sublimoon.pi.entity.Produto;
import br.com.Sublimoon.pi.repository.ProdutoRepository;
import br.com.Sublimoon.pi.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProdutoControllerTest {

    @MockBean
    ProdutoRepository produtoRepository;
    @Autowired
     private final ProdutoController produtoController = new ProdutoController();

    @Autowired
    private final ProdutoService produtoService = new ProdutoService();

    @BeforeEach
    void injectFindById(){
        Optional<Produto> produto = Optional.of(new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM"));


        Mockito.when(produtoRepository.findById(1L)).thenReturn(produto);
    }
    @BeforeEach
    void injectFindByCategoria(){
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        List<Produto> produtos = new ArrayList<>();

        produtos.add(produto);

        Mockito.when(produtoRepository.findByCategoria(Categoria.CANECA)).thenReturn(produtos);
    }
    @BeforeEach
    void injectLista(){
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        List<Produto> produtos = new ArrayList<>();

        produtos.add(produto);

        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);
    }
    @BeforeEach
    void injectListaFavoritos(){
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        List<Produto> produtos = new ArrayList<>();

        produtos.add(produto);

        Mockito.when(produtoRepository.findByAtivo(false)).thenReturn(produtos);
    }



    @Test
    void findById() {
        var produtocontroller = produtoController.findById(1L);

        String nome = produtocontroller.getBody().get().getNome();

        Assertions.assertEquals("Xicara 1", nome);
    }

    @Test
    void findByCategoria() {
        var produtocontroller = produtoController.findByCategoria(Categoria.CANECA);

        String nome = produtocontroller.getBody().get(0).getNome();

        Assertions.assertEquals("Xicara 1", nome);

    }

    @Test
    void lista() {
        var produtocontroller = produtoController.lista();

        String nome = produtocontroller.getBody().get(0).getNome();

        Assertions.assertEquals("Xicara 1", nome);
    }

    @Test
    void listaFavoritos() {
        var produtocontroller = produtoController.listaFavoritos();

        String nome = produtocontroller.getBody().get(0).getNome();

        Assertions.assertEquals("Xicara 1", nome);


    }

    @Test
    void cadastrar() {
        ProdutoDTO produto = new ProdutoDTO("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG", 20f, 1, 4, "10CM");

        var produtocontroller = produtoController.cadastrar(produto).getBody();

       // Assertions.assertEquals("ok", produtocontroller);
    }

    @Test
    void editarProduto() {
    }

    @Test
    void fav() {
    }

    @Test
    void deleta() {
    }
}