package br.com.sublimoon.pi.dto;

import lombok.Getter;
import lombok.Setter;


public class EnvioDTO extends AbstractEntityDTO {

    @Getter
    @Setter
    private String formaEnvio;

    @Getter @Setter
    private float valorFrete;

    public EnvioDTO(){

    }
    public EnvioDTO(String formaEnvio, float valorFrete) {
        this.formaEnvio = formaEnvio;
        this.valorFrete = valorFrete;
    }


}
