package br.com.sublimoon.pi.controller;

import br.com.sublimoon.pi.DTO.AdmDTO;
import br.com.sublimoon.pi.entity.Adm;
import br.com.sublimoon.pi.repository.AdmRepository;
import br.com.sublimoon.pi.service.AdmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class AdmControllerTest {

    @MockBean
    AdmRepository admRep;

    @Autowired
    private final AdmController admController = new AdmController();

    @Autowired
    private  final AdmService admService = new AdmService();

    @BeforeEach
    void injectFindById(){

        Optional<Adm> adm = Optional.of(new Adm(1L, "admin", "admin123"));

        Mockito.when(admRep.findById(1L)).thenReturn(adm);
    }
    @BeforeEach
    void injectFindAll(){

        Adm adm = new Adm(1L, "admin", "admin123");

        List<Adm> adms = new ArrayList<>();

        adms.add(adm);
        Mockito.when(admRep.findAll()).thenReturn(adms);
    }

    @Test
    void findById() {
        var admcontroller = admController.findById(1L);

        long id = admcontroller.getBody().get().getId();

        Assertions.assertEquals(1L, id);
    }

    @Test
    void lista() {
        var admcontroller = admController.lista();

        int num = admcontroller.getBody().size();

        Assertions.assertEquals(1, num);

    }

    @Test
    void cadastrarAdm() {

        AdmDTO adm = new AdmDTO("nome", "senha");

        var admcontroller = admController.cadastrarAdm(adm).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(200), admcontroller);

    }

    @Test
    void editarAdm() {
        Adm adm = new Adm(1L, "admin", "admin123");

        var admcontroller = admController.editarAdm(1L, adm).getStatusCode();

        Assertions.assertEquals(HttpStatusCode.valueOf(200), admcontroller);


    }

    @Test
    void deletaAdm() {

        var admcontroller = admController.deletaAdm(1L).getBody();

        Assertions.assertEquals("Desativado ou excluído", admcontroller);
    }
}