package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "itemCarrinho", schema = "public")
public class Item extends AbstractEntity {

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "produto",nullable = false)
    private Produto produto;

    @Getter @Setter
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Getter @Setter
    @Column(name = "valor")
    private float valor;
    @Getter @Setter
    @Column(name = "valorUnit")
    private float valorUnit;
    @Getter @Setter
    @Column(name = "valorTotal")
    private float ValorTotal = valorUnit * quantidade;

}
