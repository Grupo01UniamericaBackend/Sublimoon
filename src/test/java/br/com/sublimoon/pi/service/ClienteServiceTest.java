package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.controller.ClienteController;
import br.com.sublimoon.pi.dto.ClienteDTO;
import br.com.sublimoon.pi.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ClienteServiceTest {
    @MockBean
    ClienteRepository clienteRep;
    @Autowired
    private final ClienteService clienteService = new ClienteService(clienteRep);



    @Test
    void verificarCliente() {
        ClienteDTO cliente = new ClienteDTO("45999910373", "cliente@email.com", "cliente", "clienteTest", "06773080940");

        var clienteservice = clienteService.verificarCliente(cliente).getBody();

        Assertions.assertEquals("cliente verificado!", clienteservice);



    }

    @Test
    void delete() {

        var clienteservice = clienteService.delete(1L).getBody();

        Assertions.assertEquals("cliente deletado!", clienteservice);
    }
}