package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.entity.Envio;
import br.com.Sublimoon.PI.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Service
public class envioService {

    @Autowired
    EnvioRepository envioRepository;

    @Transactional(rollbackFor = Exception.class)
    public void validaEnvio(final Envio envio){

        Assert.isTrue(!envio.getFormaEnvio().equals(""),"Por favor, selecione uma forma de envio válida!!");
        Assert.isTrue(envio.getFormaEnvio().length() <= 30,"Forma de envio n pode passar de 30 caracteres");

        Assert.isTrue(!envio.getId().equals(""),"Id nao pode ser nulo, verifique essa informação");
    }


}
