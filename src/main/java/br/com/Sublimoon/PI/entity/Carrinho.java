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
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carrinho_produto",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "carrinho_id",
                            "produto_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "carrinho_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "produto_id"
            )
    )
    private List<Produto>produtos;

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
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "carrinho")
    private Cliente cliente;




}
