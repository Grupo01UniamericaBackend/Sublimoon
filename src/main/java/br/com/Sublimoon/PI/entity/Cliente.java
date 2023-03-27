package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "Clientes",schema = "public")
public class Cliente extends Usuario {

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Favoritos",nullable = false)
    private Favoritos favoritos;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Carrinho",nullable = false)
    private Carrinho carrinho;

    @Getter @Setter
    @Column(name = "nomeCliente",nullable = false,length = 45)
    private String nome;

    @Getter @Setter
    @Column(name = "senha",nullable = false,length = 40)
    private String senha;

    @Getter @Setter
    @Column(name = "cpf",nullable = false,unique = true,length = 30)
    private String cpf;




}
