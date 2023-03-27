package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;

@Entity
@Table(name = "Categorias", schema = "public")
public class Categorias {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategoria",nullable = false, unique = true)
    private Long id;
    @Getter @Setter
    @Column(name = "Categoria",nullable = false, length = 50)
    private String categorias;
}
