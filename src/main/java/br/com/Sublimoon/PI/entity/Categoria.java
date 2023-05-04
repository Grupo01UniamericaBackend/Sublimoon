package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categorias", schema = "public")
public class Categoria {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategoria",nullable = false, unique = true)
    private Long id;
    @Getter @Setter
    @Column(name = "Categoria",nullable = false, length = 50)
    private String categorias;
}
