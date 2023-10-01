package br.com.sublimoon.pi.DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AdmDTOTest {


    AdmDTO admDTO = new AdmDTO("userAdm", "adm");
    @Test
    void getAndSetUserAdm() {
        admDTO.setUserAdm("Adm");

    Assertions.assertEquals("Adm",admDTO.getUserAdm());
    }

    @Test
    void getAndSetSenhaAdm() {
        admDTO.setSenhaAdm("admin");

        Assertions.assertEquals("admin", admDTO.getSenhaAdm());
    }
        @Test
    void testEquals() {

            AdmDTO admDTO2 = new AdmDTO("userAdm", "adm");

            Assertions.assertTrue(admDTO.equals(admDTO2));
    }

    @Test
    void canEqual() {
        AdmDTO admDTO2 = new AdmDTO("userAdm", "adm");

        Assertions.assertTrue(admDTO.canEqual(admDTO2));
    }

    @Test
    void testHashCode() {
        AdmDTO admDTO2 = new AdmDTO("userAdm", "adm");

        Assertions.assertEquals(admDTO.hashCode(), admDTO2.hashCode());
    }

    @Test
    void testToString() {
        AdmDTO admDTO2 = new AdmDTO("userAdm", "adm");

        Assertions.assertEquals(admDTO2.toString(), admDTO.toString() );
    }
}