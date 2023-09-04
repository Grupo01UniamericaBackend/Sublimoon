package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EnvioDTO extends AbstractEntity {


    private String formaEnvio;


    private float valorFrete;


}
