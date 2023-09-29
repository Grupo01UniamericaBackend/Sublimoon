package br.com.Sublimoon.pi.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdmTest {

    Adm adm =new Adm(1L, "admin", "admin123");
    @Test
    void getAndSetUserAdm() {
        adm.setUserAdm("adm");

        Assertions.assertEquals("adm", adm.getUserAdm());
    }

    @Test
    void getAndSetSenhaAdm() {
        adm.setSenhaAdm("ADMIN");

        Assertions.assertEquals("ADMIN",adm.getSenhaAdm());
    }


}