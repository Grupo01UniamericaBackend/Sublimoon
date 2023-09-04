package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Item", schema = "public")
public class ItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name="id", nullable = false, unique = true)
    private Long id;
    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "item-produto",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "item_id",
                            "produto_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "item_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "produto_id"
            )
    )
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
