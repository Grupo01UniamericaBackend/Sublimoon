package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.dto.ClienteDTO;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.repository.ClienteRepository;
import br.com.sublimoon.pi.service.ClienteService;
import org.junit.Assert;
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

    private List<Cliente> clienteList;



    @BeforeEach
    void injectData() {
        Cliente cliente = new Cliente(1L, "cliente","odmaodmsa@omaof","Reginaldo","diamwd","312415");
        Cliente cliente2 = new Cliente(1L, "cliente2","fodmfssa@omaof","Reodamfodmo","diamdimdfd","391892415");
        clienteList = new ArrayList<>();
        clienteList.add(cliente);
        clienteList.add(cliente2);



        Mockito.when(clienteRep.save(cliente)).thenReturn(cliente);
        Mockito.when(clienteRep.save(cliente2)).thenReturn(cliente2);
        Mockito.when(clienteRep.findById(1L)).thenReturn(Optional.of(cliente));
        Mockito.when(clienteRep.findById(2L)).thenReturn(Optional.of(cliente2));
        Mockito.when(clienteRep.findAll()).thenReturn(clienteList);






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
    void testPutCliente(){
        ClienteDTO clienteDTO = new ClienteDTO("45912931","dawoda@okafo","Reginaldo","espinafre1227","12301");
        clienteDTO.setId(1L);


        var cliente = clienteController.editar(1L, clienteDTO);

        Assert.assertEquals("Registro cadastrado com sucesso", cliente.getBody());
    }

    @Test
    void testDeleteCliente(){
        var cliente = clienteController.deleta(1L);
        Assert.assertEquals("Desativado ou excluído", cliente.getBody());
    }
}