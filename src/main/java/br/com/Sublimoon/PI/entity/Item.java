package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.MathContext;
@Entity
@Table(name = "itemCarrinho", schema = "public")
public class Item extends AbstractEntity {

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "produto")
    private Produto produto;
    @Getter @Setter
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Getter @Setter
    @Column(name = "valor", nullable = false)
    private float valor;
    @Getter @Setter
    @Column(name = "valorUnit", nullable = false)
    private float valorUnit;

    @Getter
    @Column(name = "valorTotal")
    private float ValorTotal = valorUnit * quantidade;






}
