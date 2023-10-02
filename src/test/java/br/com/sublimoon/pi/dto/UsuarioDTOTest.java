package br.com.sublimoon.pi.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UsuarioDTOTest {
    UsuarioDTO usuarioDTO = new UsuarioDTO(LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 20),true, "45-40028922", "email@email.com");
    @Test
    void getAndSetCadastro() {
        usuarioDTO.setCadastro(LocalDateTime.of(2023,9, 28, 20, 20));
        Assertions.assertEquals(LocalDateTime.of(2023,9,28, 20,20), usuarioDTO.getCadastro());
    }
    @Test
    void getAndSetId() {
        usuarioDTO.setId(2L);
        Assertions.assertEquals(2L, usuarioDTO.getId());
    }
    @Test
    void getAndSetEdicao() {
        usuarioDTO.setEdicao(LocalDateTime.of(2023, 9, 28,20,20));

        Assertions.assertEquals((LocalDateTime.of(2023,9,28, 20,20)), usuarioDTO.getEdicao());
    }

    @Test
    void isAndSetAtivo() {
        usuarioDTO.setAtivo(false);

        Assertions.assertEquals(false, usuarioDTO.isAtivo());
    }

    @Test
    void getAndSetTelefone() {
        usuarioDTO.setTelefone("45-998023600");

        Assertions.assertEquals("45-998023600", usuarioDTO.getTelefone());

    }

    @Test
    void getAndSetEmail() {
        usuarioDTO.setEmail("usuario@email.com");

        Assertions.assertEquals("usuario@email.com", usuarioDTO.getEmail());
    }

    @Test
    void testEquals() {
        UsuarioDTO usuarioDTO2 = new UsuarioDTO(LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 20),true, "45-40028922", "email@email.com");

        Assertions.assertEquals(usuarioDTO, usuarioDTO2);
    }

    @Test
    void canEqual() {
        UsuarioDTO usuarioDTO2 = new UsuarioDTO(LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 20),true, "45-40028922", "email@email.com");

        Assertions.assertTrue(usuarioDTO.canEqual(usuarioDTO2));
    }

    @Test
    void testHashCode() {
        UsuarioDTO usuarioDTO2 = new UsuarioDTO(LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 20),true, "45-40028922", "email@email.com");

        Assertions.assertEquals(usuarioDTO2.hashCode(), usuarioDTO.hashCode());
    }

    @Test
    void testToString() {
        UsuarioDTO usuarioDTO2 = new UsuarioDTO(LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 20),true, "45-40028922", "email@email.com");

        Assertions.assertEquals( usuarioDTO2.toString(), usuarioDTO.toString());
    }

}