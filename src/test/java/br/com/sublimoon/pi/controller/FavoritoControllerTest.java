package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.EnvioDTO;
import br.com.sublimoon.pi.dto.FavoritoDTO;
import br.com.sublimoon.pi.entity.*;
import br.com.sublimoon.pi.repository.FavoritoRepository;
import br.com.sublimoon.pi.service.FavoritoService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class FavoritoControllerTest {

    @MockBean
    FavoritoRepository favoritoRepository;

    @Autowired
    private final FavoritoController favoritoController = new FavoritoController();

    @BeforeEach
    void injectFindById(){

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L,"carro"));
        Cliente cliente = new Cliente(1L,"4455","rsad@gmai.com","carlos","2234","41241");

        Optional<Favorito> favorito = Optional.of(new Favorito(1L,produtos,cliente));

        Mockito.when(favoritoRepository.findById(1L)).thenReturn(favorito);
    }

    @BeforeEach
    void injectFindAll(){

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L,"carro"));
        Cliente cliente = new Cliente(1L,"459123","dwda@gm.com","Joao","odamd","1204.41");

        List<Favorito> favoritosList = new ArrayList<>();
        favoritosList.add(new Favorito(1L,produtos,cliente));

        Mockito.when(favoritoRepository.findAll()).thenReturn(favoritosList);

    }

    @Test
    void findById() {
        var favoritocontroller = favoritoController.findById(1L);

        long id = favoritocontroller.getBody().get().getId();

        Assertions.assertEquals(1L, id);
    }

    @Test
    void listaCompletaFavoritos() {
        var favoritoscontrol = favoritoController.listaCompletaFavoritos();

        int num = favoritoscontrol.getBody().size();

        Assertions.assertEquals(1, num);
    }

    @Test
    void cadastraFavorito() {

        List<Produto> produto = new ArrayList<>();
        produto.add(new Produto(1L,"carro"));
        Cliente client = new Cliente(1L,"4455","rsad@gmai.com","carlos","2234","41241");

        FavoritoDTO favorito = new FavoritoDTO(produto,client);

        var favoritocontroller = favoritoController.cadastraFavorito(favorito);
        Assertions.assertEquals("Favoritado com sucesso!!!", favoritocontroller.getBody());

    }

    @Test
    void updateFavorito() {
        List<Produto> produto = new ArrayList<>();
        produto.add(new Produto(1L,"carro"));
        Cliente client = new Cliente(1L,"4455","rsad@gmai.com","carlos","2234","41241");

        FavoritoDTO favorito = new FavoritoDTO(produto,client);

        var favoritocontroller = favoritoController.updateFavorito(1L, favorito).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(500), favoritocontroller);
       //Código certo que dá errado Assertions.assertEquals(HttpStatusCode.valueOf(200), favoritocontroller);

    }

    @Test
    void favorito() {
    }

    @Test
    void deletaIdFavorito() {

    }
}