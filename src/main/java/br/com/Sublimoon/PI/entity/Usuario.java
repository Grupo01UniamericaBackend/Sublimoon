package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Usuários",schema = "public")
public class Usuario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idCliente",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "telefone",nullable = false,unique = true,length = 40)
    private String telefone;

    @Getter @Setter
    @Column (name = "email",nullable = false,unique = true,length = 50)
    private String email;

}
