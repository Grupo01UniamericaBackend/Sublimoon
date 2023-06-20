package br.com.Sublimoon.PI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itemCarrinho", schema = "public")
public class Item extends AbstractEntity {

    @Getter @Setter
    @OneToOne
    private Produto produto;
    @Getter @Setter
    private int quantidade;
    @Getter @Setter
    private float valor;
    @Getter @Setter
    private float valorUnit;



}
