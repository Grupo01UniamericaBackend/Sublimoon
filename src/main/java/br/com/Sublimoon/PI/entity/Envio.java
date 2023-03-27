package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Envios",schema = "public")
public class Envio {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idCliente",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "formaEnvio",nullable = false,length = 30)
    private String formaEnvio;

    @Getter @Setter
    @Column(name = "valorFrete",nullable = false)
    private float valorFrete;

}
