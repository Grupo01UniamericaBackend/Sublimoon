package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.AvaliacaoDTO;
import br.com.sublimoon.pi.entity.*;
import br.com.sublimoon.pi.repository.AvaliacaoRepository;
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
class AvaliacaoControllerTest {


    @MockBean
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private  final AvaliacaoController avaliacaoController = new AvaliacaoController();

    @BeforeEach
    void injectFindById(){

        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Optional<Avaliacao> avaliacao = Optional.of(new Avaliacao(4.5F, "OK", cliente, produto));

        Mockito.when(avaliacaoRepository.findById(1L)).thenReturn(avaliacao);


    }@BeforeEach
    void injectGetById(){

        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Avaliacao avaliacao = new Avaliacao(4.5F, "OK", cliente, produto);

        Mockito.when(avaliacaoRepository.getReferenceById(1L)).thenReturn(avaliacao);


    }

    @BeforeEach
    void injectAll(){

        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Avaliacao avaliacao = new Avaliacao(4.5F, "OK", cliente, produto);

        List<Avaliacao> avaliacoes = new ArrayList<>();

        avaliacoes.add(avaliacao);

        Mockito.when(avaliacaoRepository.findAll()).thenReturn(avaliacoes);


    }
    @Test
    void findById() {
        var avalicaocontroller = avaliacaoController.findById(1L);
        String comentario = avalicaocontroller.getBody().get().getComentario();

        Assertions.assertEquals("OK", comentario);


    }

    @Test
    void lista() {
        var avaliacaocontroller = avaliacaoController.lista();

        int num = avaliacaocontroller.getBody().size();


        Assertions.assertEquals(1, num);
    }

    @Test
    void cadastrarAvaliacao() {
        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        AvaliacaoDTO avaliacao = new AvaliacaoDTO(4.5F, "OK", cliente, produto);


        var avaliacaocontroller = avaliacaoController.cadastrarAvaliacao(avaliacao).getBody();

        Assertions.assertEquals("Avaliado com sucesso", avaliacaocontroller);

    }

    @Test
    void editarAvaliacao() {
        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Avaliacao avaliacao = new Avaliacao(4.5F, "OK", cliente, produto);


        var avaliacaocontroller = avaliacaoController.editarAvaliacao(1L, avaliacao).getBody();

        Assertions.assertEquals("Produto editado no estoque com Sucesso", avaliacaocontroller);

    }

    @Test
    void deletaAvaliacao() {

        var avaliacaocontroller = avaliacaoController.deletaAvaliacao(1L).getBody();

        Assertions.assertEquals("Desativado ou excluído", avaliacaocontroller);
    }
}