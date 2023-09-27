package br.com.sublimoon.pi.DTO;

import br.com.sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

@Data
public class EnvioDTO extends AbstractEntity {


    private String formaEnvio;


    private float valorFrete;


}
