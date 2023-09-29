package br.com.Sublimoon.pi.controller;

import br.com.Sublimoon.pi.DTO.AdmDTO;
import br.com.Sublimoon.pi.entity.Adm;
import br.com.Sublimoon.pi.repository.AdmRepository;
import br.com.Sublimoon.pi.service.AdmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

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

        AdmDTO adm = new AdmDTO();

        var admcontroller = admController.cadastrarAdm(adm).getStatusCode();

       // Assertions.assertEquals(ResponseEntity.ok(), admcontroller);

    }

    @Test
    void editarAdm() {
    }

    @Test
    void deletaAdm() {
    }
}