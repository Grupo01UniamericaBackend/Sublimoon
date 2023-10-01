package br.com.sublimoon.pi.DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnvioDTOTest {

    EnvioDTO envioDTO = new EnvioDTO("TesteDTO", 99);
    EnvioDTO envioDTO2 = new EnvioDTO();

    @Test
    void getSetFormaEnvio(){
        envioDTO.setFormaEnvio("Lancha");
        Assertions.assertEquals("Lancha",envioDTO.getFormaEnvio());
    }
    @Test
    void construtorVazioTest(){
        EnvioDTO envioDTO3 = new EnvioDTO();
        Assertions.assertEquals(envioDTO2,envioDTO3);
    }
    @Test
    void testHashCode() {
        EnvioDTO envioDTO1 = new EnvioDTO("teste1",99);
        EnvioDTO envioDTO2 = new EnvioDTO("teste1",99);
        Assertions.assertEquals(envioDTO1.hashCode(),envioDTO2.hashCode());
    }
    @Test
    void testToString() {
        EnvioDTO envioDTO1 = new EnvioDTO("TesteDTO", 99);
        Assertions.assertEquals(envioDTO1.toString(),envioDTO.toString());
    }
    @Test
    void comparacaoFormaDeEnvioTest(){
        EnvioDTO envioDTO1 = new EnvioDTO("TesteDTO", 99);
        Assertions.assertEquals(envioDTO.getFormaEnvio(),envioDTO1.getFormaEnvio());
    }
    @Test
    void comapracaoValorFreteTest(){
        EnvioDTO envioDTO1 = new EnvioDTO("TesteDTO", 99);
        Assertions.assertEquals(envioDTO.getValorFrete(),envioDTO1.getValorFrete());
    }
}