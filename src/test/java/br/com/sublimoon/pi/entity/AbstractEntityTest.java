package br.com.sublimoon.pi.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class AbstractEntityTest {

    Usuario usuario = new Usuario(1L, LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 24)
            ,true, "45-40028922", "email@email.com");

    @Test
    void getId() {

        Assertions.assertEquals(1L, usuario.getId());
    }

    @Test
    void getAndSetCadastro() {

        usuario.setCadastro(LocalDateTime.of(2023,10, 02, 01, 12));

        Assertions.assertEquals(LocalDateTime.of(2023,10, 02, 01, 12), usuario.getCadastro());
    }

    @Test
    void getAndSetEdicao() {
        usuario.setEdicao(LocalDateTime.of(2023,10, 2, 1, 12));

        Assertions.assertEquals(LocalDateTime.of(2023,10, 2, 1, 12), usuario.getEdicao());

    }

    @Test
    void isAndSetAtivo() {
        usuario.setAtivo(false);

        Assertions.assertEquals(false, usuario.isAtivo());
    }


}