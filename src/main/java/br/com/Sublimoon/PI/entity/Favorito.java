package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name = "Favoritos",schema = "public")
public class Favorito {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    long produtoId;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Favorito_produto",
            joinColumns = @JoinColumn(name = "favorito_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto>produtos;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente")
    private Cliente cliente;

}
