package br.com.sublimoon.pi.service;


import br.com.sublimoon.pi.dto.AvaliacaoDTO;
import br.com.sublimoon.pi.entity.*;
import br.com.sublimoon.pi.repository.AvaliacaoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@SpringBootTest
class AvaliacaoServiceTest {

    @MockBean
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private final AvaliacaoService avaliacaoService = new AvaliacaoService(avaliacaoRepository);

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

    @Test
    void createAvaliacao() {
        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        AvaliacaoDTO avaliacao = new AvaliacaoDTO(4.5F, "OK", cliente, produto);

        var avaliacaoservice = avaliacaoService.createAvaliacao(avaliacao).getBody();

        Assertions.assertEquals("Avaliação criada com sucesso!", avaliacaoservice);
    }

    @Test
    void atualizaAvaliacao() {
        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
        Produto produto = new Produto("Xicara 1", Categoria.CANECA, Cor.BRANCO, "...", "IMG",20f,1,4,"10CM");
        Avaliacao avaliacao = new Avaliacao(4.5F, "OK", cliente, produto);

        var avaliacaoservice = avaliacaoService.atualizaAvaliacao(1L, avaliacao).getBody();

        Assertions.assertEquals("Avaliação atualizada!", avaliacaoservice);
    }

    @Test
    void delete() {
        var avalicaoservice = avaliacaoService.delete(1L).getBody();

        Assertions.assertEquals("Avaliação deletada com sucesso!", avalicaoservice);
    }
}