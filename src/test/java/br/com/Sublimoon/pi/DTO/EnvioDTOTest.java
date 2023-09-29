package br.com.Sublimoon.pi.DTO;
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
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}