package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Envios",schema = "public")
public class EnvioDTO extends AbstractEntity {

    @Getter @Setter
    @Column(name = "formaEnvio",nullable = false,length = 30)
    private String formaEnvio;

    @Getter @Setter
    @Column(name = "valorFrete",nullable = false)
    private float valorFrete;


}
