package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Categorias", schema = "public")
public class Categoria extends AbstractEntity{


    @Getter @Setter
    @Column(name = "Categoria",nullable = false, length = 50)
    private String categorias;

}
