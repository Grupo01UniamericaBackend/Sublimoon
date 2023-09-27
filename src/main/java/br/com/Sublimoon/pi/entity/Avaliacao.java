package br.com.Sublimoon.pi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name ="Avaliações",schema = "public")
public class Avaliacao extends AbstractEntity{


    @Getter @Setter
    @Column(name = "nota",nullable = false)
    private Float nota;


    @Getter @Setter
    @Column(name = "comentario",length = 150)
    private String comentario;


    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "avaliacao_cliente",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "avaliacao_id",
                            "cliente_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "avaliacao_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cliente_id"


            )

    )
    private Cliente cliente;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "avaliacao_produto",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "avaliacao_id",
                            "produto_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "avaliacao_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "produto_id"
            )
    )
    private Produto produto;




}
