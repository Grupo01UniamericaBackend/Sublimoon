package br.com.sublimoon.pi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Envios",schema = "public")
public class Envio extends AbstractEntity{

    @Getter @Setter
    @Column(name = "formaEnvio",nullable = false,length = 30)
    private String formaEnvio;

    @Getter @Setter
    @Column(name = "valorFrete",nullable = false)
    private float valorFrete;


}
