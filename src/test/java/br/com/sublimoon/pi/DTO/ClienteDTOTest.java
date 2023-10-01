package br.com.sublimoon.pi.DTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteDTOTest {

    ClienteDTO clienteDTO = new ClienteDTO("40028922", "naosei@email.com", "nome", "123","06773080940");
    @Test
    void getAndSetTelefone() {
        clienteDTO.setTelefone("98023600");

        Assertions.assertEquals("98023600", clienteDTO.getTelefone());
    }

    @Test
    void getAndSetEmail() {

        clienteDTO.setEmail("email@email.com");

        Assertions.assertEquals("email@email.com", clienteDTO.getEmail());
    }

    @Test
    void getAndSetNome() {
        clienteDTO.setNome("clienteDto");

        Assertions.assertEquals("clienteDto", clienteDTO.getNome());
    }

    @Test
    void getAndSetSenha() {

        clienteDTO.setSenha("12345");

        Assertions.assertEquals("12345", clienteDTO.getSenha());
    }

    @Test
    void getAndSetCpf() {

        clienteDTO.setCpf("06773077990");
        Assertions.assertEquals("06773077990", clienteDTO.getCpf());
    }


    @Test
    void testEquals() {
        ClienteDTO clienteDTO2 = new ClienteDTO("40028922", "naosei@email.com", "nome", "123","06773080940");

        Assertions.assertTrue(clienteDTO2.equals(clienteDTO));
    }

    @Test
    void canEqual() {
        ClienteDTO clienteDTO2 = new ClienteDTO("40028922", "naosei@email.com", "nome", "123","06773080940");

        Assertions.assertTrue(clienteDTO.canEqual(clienteDTO2));
    }

    @Test
    void testHashCode() {
        ClienteDTO clienteDTO2 = new ClienteDTO("40028922", "naosei@email.com", "nome", "123","06773080940");
        Assertions.assertEquals(clienteDTO.hashCode(), clienteDTO2.hashCode());
    }

    @Test
    void testToString() {
        ClienteDTO clienteDTO2 = new ClienteDTO("40028922", "naosei@email.com", "nome", "123","06773080940");

        Assertions.assertEquals(clienteDTO2.toString(), clienteDTO.toString());
    }
}