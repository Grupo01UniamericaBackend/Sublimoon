package br.com.sublimoon.pi.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class AbstractEntityDTOTest {

    UsuarioDTO usuarioDTO = new UsuarioDTO(LocalDateTime.of(2023,9, 28, 20, 12), LocalDateTime.of(2023,9, 28, 20, 24)
            ,true, "45-40028922", "email@email.com");

    @Test
    void getAndSetCadastro() {

        usuarioDTO.setCadastro(LocalDateTime.of(2023,10, 2, 1, 12));

        Assertions.assertEquals(LocalDateTime.of(2023,10, 2, 1, 12), usuarioDTO.getCadastro());
    }

    @Test
    void getAndSetEdicao() {
        usuarioDTO.setEdicao(LocalDateTime.of(2023,10, 2, 1, 12));

        Assertions.assertEquals(LocalDateTime.of(2023,10, 2, 1, 12), usuarioDTO.getEdicao());

    }

    @Test
    void isAndSetAtivo() {
        usuarioDTO.setAtivo(false);

        Assertions.assertFalse(usuarioDTO.isAtivo());
    }



}