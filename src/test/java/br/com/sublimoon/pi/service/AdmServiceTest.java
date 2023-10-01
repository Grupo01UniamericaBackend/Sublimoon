package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.dto.AdmDTO;
import br.com.sublimoon.pi.entity.Adm;
import br.com.sublimoon.pi.repository.AdmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
class AdmServiceTest {
    @MockBean
    AdmRepository admRep;

    @Autowired
    private  final AdmService admService = new AdmService();
    @BeforeEach
    void injectFindById(){

        Optional<Adm> adm = Optional.of(new Adm(1L, "admin", "admin123"));

        Mockito.when(admRep.findById(1L)).thenReturn(adm);
    }

    @Test
    void createAdm() {
        AdmDTO adm = new AdmDTO("nome", "senha");

        var admservice =admService.createAdm(adm).getBody();

        Assertions.assertEquals("adm criado com sucesso!", admservice);
    }

    @Test
    void editaADM() {
        Adm adm = new Adm(1L, "nome", "senha");

        var admservice = admService.editaADM(adm).getBody();

        Assertions.assertEquals("adm alterado com sucesso!", admservice);

    }

    @Test
    void delete() {

        var admservice = admService.delete(1L).getBody();

        Assertions.assertEquals("adm deletado com sucesso!", admservice);
    }
}