package br.com.sublimoon.pi.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ClienteTest {

    Cliente cliente = new Cliente(1L,"45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");
    @Test
    void getAndSetTelefone() {

        cliente.setTelefone("45-999950385");

        Assertions.assertEquals("45-999950385", cliente.getTelefone());
    }

    @Test
    void getAndSetEmail() {
        cliente.setEmail("clienteTest@email.com");

        Assertions.assertEquals("clienteTest@email.com", cliente.getEmail());
    }

    @Test
    void getAndSetNome() {

        cliente.setNome("tester");

        Assertions.assertEquals("tester", cliente.getNome());
    }

    @Test
    void getAndSetSenha() {
        cliente.setSenha("cliente123");

        Assertions.assertEquals("cliente123", cliente.getSenha());
    }

    @Test
    void getAndSetCpf() {

        cliente.setCpf("06773077990");

        Assertions.assertEquals("06773077990", cliente.getCpf());
    }




}