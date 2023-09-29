package br.com.Sublimoon.pi.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UsuarioTest {

    Usuario usuario = new Usuario(1L, LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 24)
            ,true, "45-40028922", "email@email.com");

    @Test
    void getAndSetId() {

        Assertions.assertEquals(1L, usuario.getId());
    }

    @Test
    void getAndSetCadastro() {

        usuario.setCadastro(LocalDateTime.of(2023, 9, 28,20,20));

        Assertions.assertEquals(LocalDateTime.of(2023,9,28, 20,20), usuario.getCadastro());
    }

    @Test
    void getAndSetEdicao() {
        usuario.setEdicao(LocalDateTime.of(2023, 9, 28,20,20));

        Assertions.assertEquals((LocalDateTime.of(2023,9,28, 20,20)), usuario.getEdicao());
    }

    @Test
    void isAndSetAtivo() {
        usuario.setAtivo(false);

        Assertions.assertEquals(false, usuario.isAtivo());
    }

    @Test
    void getAndSetTelefone() {
        usuario.setTelefone("45-998023600");

        Assertions.assertEquals("45-998023600", usuario.getTelefone());

    }

    @Test
    void getAndSetEmail() {
        usuario.setEmail("usuario@email.com");

        Assertions.assertEquals("usuario@email.com", usuario.getEmail());
    }

}