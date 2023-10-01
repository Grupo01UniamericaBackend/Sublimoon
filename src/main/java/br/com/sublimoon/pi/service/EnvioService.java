package br.com.sublimoon.pi.service;

import br.com.sublimoon.pi.DTO.EnvioDTO;
import br.com.sublimoon.pi.entity.Envio;
import br.com.sublimoon.pi.repository.EnvioRepository;
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

    public void atualizaEnvio(Envio envio){

        this.envioRepository.save(envio);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        final Envio envioEmBranco =this.envioRepository.findById(id).orElse(null);

        if (envioEmBranco == null || !envioEmBranco.getId().equals(id)){
            throw  new RuntimeException("Nao foi possivel identificar o Id");
        }
        this.envioRepository.delete(envioEmBranco);


    }


}
