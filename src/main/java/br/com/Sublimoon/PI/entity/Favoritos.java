package br.com.Sublimoon.PI.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "Favoritos",schema = "public")
public class Favoritos {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFavoritos",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Favorito_produto",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "favorito_id",
                            "produto_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "favorito_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "produto_id"
            )
    )
    private List<Produtos>produtos;
}
