package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.entity.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Favoritos",schema = "public")
public class FavoritoDTO extends AbstractEntity {


    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "favorito_produto",
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

    @Getter @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "favorito_cliente",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "favorito_id",
                            "cliente_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "favorito_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cliente_id"
            )

    )
    private Cliente cliente;

}
