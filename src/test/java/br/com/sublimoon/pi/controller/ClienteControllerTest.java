package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.ClienteDTO;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.repository.ClienteRepository;
import br.com.sublimoon.pi.service.ClienteService;
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
    private final ClienteController clienteController = new ClienteController();

    @Autowired
    private final ClienteService clienteService = new ClienteService(clienteRep);

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

        ClienteDTO cliente = new ClienteDTO("45999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");

        var clienteResposta = clienteController.cadastrar(cliente);
        Assertions.assertEquals("Registro cadastrado com sucesso", clienteResposta.getBody());

    }

    @Test
    void editar() {
    }

    @Test
    void deleta() {
    }
}