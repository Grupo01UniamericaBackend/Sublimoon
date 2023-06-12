package br.com.Sublimoon.PI.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Favoritos",schema = "public")
public class Favorito {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFavoritos",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY)
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
    private List<Produto>produtos;
}
