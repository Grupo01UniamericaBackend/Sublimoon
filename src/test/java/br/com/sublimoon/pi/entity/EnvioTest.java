package br.com.sublimoon.pi.entity;
import br.com.sublimoon.pi.DTO.EnvioDTO;
import br.com.sublimoon.pi.repository.EnvioRepository;
import br.com.sublimoon.pi.controller.EnvioController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
class EnvioTest {

    @MockBean
    EnvioRepository envioRepository;
    @Autowired
    EnvioController envioController = new EnvioController();
    private List<Envio> envioList;

   @BeforeEach
   void injectData(){
       Envio envio = new Envio(1L,"Correios",8);
       Envio envio2 = new Envio(2L,"Aviao",100);
       envioList = new ArrayList<>();
       envioList.add(envio);
       envioList.add(envio2);

       Mockito.when(envioRepository.save(envio)).thenReturn(envio);
       Mockito.when(envioRepository.save(envio2)).thenReturn(envio2);
       Mockito.when(envioRepository.findById(1L)).thenReturn(Optional.of(envio));
       Mockito.when(envioRepository.findById(2L)).thenReturn(Optional.of(envio2));
       Mockito.when(envioRepository.findAll()).thenReturn(envioList);

   }

    @Test
   void cadastraEnvio(){
        var envio = envioController.cadastrarEnvio(new EnvioDTO("TomaTeste",10));
        Assertions.assertEquals("Envio cadastrado com sucesso", envio.getBody());
    }
    @Test
    void cadastraEnvioErrado(){
        var envio = envioController.cadastrarEnvio(new EnvioDTO());
        Assertions.assertEquals("Error: Cannot invoke \"String.equals(Object)\" because the return value of \"entity.br.com.sublimon.pi.Envio.getFormaEnvio()\" is null",envio.getBody());
    }
    @Test
    void putEnvio(){
        Envio envio1 = new Envio(1L, "Put",99);
        var envioPut = envioController.editar(1L, envio1);
        Assertions.assertEquals("Envio editado com sucesso!",envioPut.getBody());
    }
    @Test
    void putEnvioErrado(){
        Envio envio1 = new Envio(2L,"PutErrado",8);
        var envio = envioController.editar(7L,envio1);
        Assertions.assertEquals("Error: Nao foi possivel identificar o envio informado",envio.getBody());
    }
    @Test
    void deleteEnvioTest(){
        var envio= envioController.deletaIdEnvio(1L);
        Assertions.assertEquals("Envio excluido",envio.getBody());
    }
    @Test
    void deleteEnvioErrado(){
        var envio =envioController.deletaIdEnvio(100L);
        Assertions.assertEquals("Error: Nao foi possivel identificar o Id",envio.getBody());
    }
    @Test
    void findByIdEnvio(){
        envioController.cadastrarEnvio(new EnvioDTO("TomaID",99));
        var envio = envioController.findById(1L);
        Assertions.assertEquals(Objects.requireNonNull(envio.getBody().get()).getFormaEnvio(), Objects.requireNonNull(envioController.findById(1L).getBody().get()).getFormaEnvio());
    }
    @Test
    void findAllEnvioTest(){
        ResponseEntity<List<Envio>> envioFuncaoController = envioController.listaCompletaEnvio();
        List<Envio> envioListController =envioFuncaoController.getBody();
        Assertions.assertNotNull(envioListController);
        for(int i = 0; i < envioList.size(); i++){
            Assertions.assertEquals(envioList.get(i),envioListController.get(i));
        }
    }
}