package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Carrinhos",schema = "public")
public class Carrinho extends  AbstractEntity{

    @Getter @Setter
    @Column(name = "quantidade")
    private int quantidade;


    @Getter @Setter
    @Column(name = "desconto")
    private float desconto;

    @Getter @Setter
    @Column (name = "subTotal")
    private float subTotal;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "carrinho_cliente",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "carrinho_id",
                            "cliente_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "carrinho_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cliente_id"
            )
    )
    private Cliente cliente;
    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "carrinho_item",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "carrinho_id",
                            "item_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "carrinho_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "item_id"
            )
    )
    private List<Item> Item;

}
