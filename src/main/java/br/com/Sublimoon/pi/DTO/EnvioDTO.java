package br.com.Sublimoon.pi.DTO;

import br.com.Sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

@Data
public class EnvioDTO extends AbstractEntity {


    private String formaEnvio;


    private float valorFrete;


}
