package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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
    private List<Item> item;


    public Carrinho(Long id,int quantidade, float desconto, float subTotal, Cliente cliente, List<br.com.sublimoon.pi.entity.Item> item) {
        this.id = id;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.subTotal = subTotal;
        this.cliente = cliente;
        this.item = item;
    }

    public Carrinho() {

    }
}
