package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name ="Avaliações",schema = "public")
public class Avaliacao {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAvaliação",nullable = false,unique = true)
    private Long idAvaliacao;

    @Getter @Setter
    @Column(name = "nota",nullable = false)
    private Float nota;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "Cliente",nullable = false)
    private Cliente cliente;

    @Getter @Setter
    @Column (name = "comentário",nullable = false, length = 150)
    private String comentario;
}
