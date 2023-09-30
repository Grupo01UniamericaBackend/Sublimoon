package br.com.Sublimoon.pi.controller;

import br.com.Sublimoon.pi.entity.Cliente;
import br.com.Sublimoon.pi.repository.ClienteRepository;
import br.com.Sublimoon.pi.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ClienteControllerTest {

    @MockBean
    ClienteRepository clienteRep;

    @Autowired
    ClienteController clienteController = new ClienteController();

    @Autowired
    ClienteService clienteService = new ClienteService();

    @BeforeEach
    void injectFindById(){
        Optional<Cliente> cliente = Optional.of(new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940"));

        Mockito.when(clienteRep.findById(1L)).thenReturn(cliente);
    }
    @BeforeEach
    void injectFindAll(){
        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente);
        Mockito.when(clienteRep.findAll()).thenReturn(clientes);
    }

    @Test
    void findById() {
        var clientecontroller = clienteController.findById(1L);

        String nome = clientecontroller.getBody().get().getNome();


        Assertions.assertEquals("cliente", nome);
    }

    @Test
    void lista() {
        var clientecontroller = clienteController.lista();

        int num = clientecontroller.getBody().size();

        Assertions.assertEquals(1 , num);
    }

    @Test
    void cadastrar() {

        Cliente cliente = new Cliente("45-999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");

        var clientecontroller = clienteController.cadastrar(cliente);
        String resposta = clientecontroller.getStatusCode().toString();

       // Assertions.assertEquals("ok", resposta);

    }

    @Test
    void editar() {
    }

    @Test
    void deleta() {
    }
}