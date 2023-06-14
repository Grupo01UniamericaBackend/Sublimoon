package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name = "Favoritos",schema = "public")
public class Favorito extends AbstractEntity{


    @Getter @Setter
    private Long produtoId;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "favoritos")
    private List<Produto>produtos;

    @Getter @Setter
    @OneToOne(mappedBy = "favorito")
    private Cliente cliente;

}
