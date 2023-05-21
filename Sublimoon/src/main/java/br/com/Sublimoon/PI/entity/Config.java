package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

@Entity

@Entity

@Table(name = "configurações" , schema = "public")
public class Config {


    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idConfig",nullable = false, unique = true)
    private Long id;
<<<<<<< HEAD:src/main/java/br/com/Sublimoon/PI/entity/Config.java
=======

>>>>>>> 9ff1c53b05fe42b4e4bf6712d3e91600bff4043a:Sublimoon/src/main/java/br/com/Sublimoon/PI/entity/Config.java
    @Getter @Setter
    @Column(name = "alterarNome")
    private String alterarNome;

    @Getter @Setter
    @Column(name = "alterarDescrição")
    private String alterarDescricao;

    @Getter @Setter
    @Column(name = "alterarImagem")
    private String valorHora;

    @Getter @Setter
    @Column(name = "alterarPreço")
    private BigDecimal alterarPreco;

    @Getter @Setter
    @Column(name = "alterarQnt")
    private int alterarQnt;



}
