package br.com.sublimoon.pi.dto;

import lombok.Data;

@Data
public class EnvioDTO extends AbstractEntityDTO {


    private String formaEnvio;


    private float valorFrete;

    public EnvioDTO(){

    }
    public EnvioDTO(String formaEnvio, float valorFrete) {
        this.formaEnvio = formaEnvio;
        this.valorFrete = valorFrete;
    }


}
