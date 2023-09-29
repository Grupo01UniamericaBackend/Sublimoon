package br.com.Sublimoon.pi.DTO;

import br.com.Sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

@Data
public class EnvioDTO extends AbstractEntity {


    private String formaEnvio;


    private float valorFrete;

    public EnvioDTO(){

    }
    public EnvioDTO(String formaEnvio, float valorFrete) {
        this.formaEnvio = formaEnvio;
        this.valorFrete = valorFrete;
    }
}
