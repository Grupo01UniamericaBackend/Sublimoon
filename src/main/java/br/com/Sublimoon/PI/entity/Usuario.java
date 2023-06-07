package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
public class Usuario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idUsuario",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "telefone",nullable = false,unique = true,length = 40)
    private String telefone;

    @Getter @Setter
    @Column (name = "email",nullable = false,unique = true,length = 50)
    private String email;

}
