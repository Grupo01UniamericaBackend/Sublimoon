package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.AdmDTO;
import br.com.sublimoon.pi.dto.EnvioDTO;
import br.com.sublimoon.pi.entity.Adm;
import br.com.sublimoon.pi.entity.Envio;
import br.com.sublimoon.pi.repository.AdmRepository;
import br.com.sublimoon.pi.repository.EnvioRepository;
import br.com.sublimoon.pi.service.AdmService;
import br.com.sublimoon.pi.service.EnvioService;
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
class EnvioControllerTest {

    @MockBean
    EnvioRepository envioRep;

    @Autowired
    private final EnvioController envioController = new EnvioController();

    @Autowired
    private  final EnvioService envioService = new EnvioService();

    @BeforeEach
    void injectFindById(){

        Optional<Envio> envio = Optional.of(new Envio(1L, "Carro",12));

        Mockito.when(envioRep.findById(1L)).thenReturn(envio);
    }
    @BeforeEach
    void injectFindAll(){

        Envio envio = new Envio(1L, "Carro",12);

        List<Envio> envios = new ArrayList<>();

        envios.add(envio);
        Mockito.when(envioRep.findAll()).thenReturn(envios);
    }

    @Test
    void findById() {
        var enviocontroller = envioController.findById(1L);

        long id = enviocontroller.getBody().get().getId();

        Assertions.assertEquals(1L, id);
    }

    @Test
    void lista() {
        var enviocontroller = envioController.listaCompletaEnvio();

        int num = enviocontroller.getBody().size();

        Assertions.assertEquals(1, num);

    }

    @Test
    void cadastrarEnvio() {

        EnvioDTO envio = new EnvioDTO( "Carro",12);

        var enviocontroller = envioController.cadastrarEnvio(envio).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(200), enviocontroller);

    }

    @Test
    void cadastrarEnvioErrado() {

        EnvioDTO envio = new EnvioDTO( null,12);

        var enviocontroller = envioController.cadastrarEnvio(envio).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(500), enviocontroller);

    }

    @Test
    void editarEnvio() {
        Envio envio = new Envio(1L, "Carro",12);

        var enviocontroller = envioController.editar(1L, envio).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(200), enviocontroller);


    }

    @Test
    void deletaEnvio() {

        var enviocontroller = envioController.deletaIdEnvio(1L).getBody();

        Assertions.assertEquals("Envio excluido", enviocontroller);
    }
}