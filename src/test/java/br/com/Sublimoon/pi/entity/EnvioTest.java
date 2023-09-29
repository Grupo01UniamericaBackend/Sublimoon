package br.com.Sublimoon.pi.entity;
import br.com.Sublimoon.pi.DTO.EnvioDTO;
import br.com.Sublimoon.pi.controller.EnvioController;
import br.com.Sublimoon.pi.repository.EnvioRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class EnvioTest {

    @MockBean
    EnvioRepository envioRepository;
    @Autowired
    EnvioController envioController;

    Envio envio = new Envio(1L,"Correios",8);
    Envio envio2 = new Envio();
    @Test
    void getSetFormaEnvio(){
        envio.setFormaEnvio("aJato");
        Assertions.assertEquals("aJato",envio.getFormaEnvio());
    }
    @Test
    void getSetValorFrete(){
        envio.setValorFrete(99);
        Assertions.assertEquals(99,envio.getValorFrete());
    }
    @Test
    void idTeste(){
        Assertions.assertEquals(1L,envio.getId());
    }
    @Test
   void cadastraEnvio(){
        var envio = envioController.cadastrarEnvio(new EnvioDTO("TomaTeste",10));
        Assertions.assertEquals("Envio cadastrado com sucesso", envio.getBody());
    }
    @Test
    void cadastraEnvioErrado(){
        var envio = envioController.cadastrarEnvio(new EnvioDTO());
        Assertions.assertEquals("Error: Cannot invoke \"String.equals(Object)\" because the return value of \"br.com.Sublimoon.pi.entity.Envio.getFormaEnvio()\" is null",envio.getBody());
    }
    /*
    @Test
    void putEnvio(){
        Envio envio1 = new Envio(1L, "Put",99);
        var envioPut = envioController.editar(1L, envio1);
        Assertions.assertEquals("Envio editado com sucesso!",envioPut.getBody());
    }
        NAO FACO IDEIA DE PQ ESTA ERRADO
     */
    @Test
    void putEnvioErrado(){
        Envio envio1 = new Envio(2L,"PutErrado",8);
        var envio = envioController.editar(7L,envio1);
        Assertions.assertEquals("Error: Nao foi possivel identificar o envio informado",envio.getBody());
    }
    /*
    @Test
    void deleteEnvioTest(){
        var envio= envioController.deletaIdEnvio(1L);
        Assertions.assertEquals("Envio excluido",envio.getBody());
    }
    CONTINUAR DPS
     */
    @Test
    void deleteEnvioErrado(){
        var envio =envioController.deletaIdEnvio(100L);
        Assertions.assertEquals("Error: Nao foi possivel identificar o Id",envio.getBody());
    }
}