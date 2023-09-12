package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.DTO.EnvioDTO;
import br.com.Sublimoon.PI.entity.Envio;
import br.com.Sublimoon.PI.repository.EnvioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


@Service
public class EnvioService {

    @Autowired
    EnvioRepository envioRepository;

    @Transactional(rollbackFor = Exception.class)
    public void validaEnvio(final EnvioDTO envioDTO){

        var envio = new Envio();
        BeanUtils.copyProperties(envioDTO,envio);

        Assert.isTrue(!envio.getFormaEnvio().equals(""),"Por favor, selecione uma forma de envio válida!!");
        Assert.isTrue(envio.getFormaEnvio().length() <= 30,"Forma de envio n pode passar de 30 caracteres");

        this.envioRepository.save(envio);

    }

    @Transactional(rollbackFor = Exception.class)
    public void atualizaEnvio(Envio envio){
        final Envio envioAtt =this.envioRepository.findById(envio.getId()).orElse(null);

        this.envioRepository.save(envio);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){

        this.envioRepository.deleteById(id);


    }


}
