package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Carrinhos",schema = "public")
public class Carrinho {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idCarrinho",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @ManyToMany
    @JoinTable(name = "carrinho_produto",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;


    @Getter @Setter
    @Column(name = "quantidade",nullable = false)
    private int quantidade;

    @Getter @Setter
    @Column(name = "desconto")
    private BigDecimal desconto;

    @Getter @Setter
    @Column (name = "subTotal",nullable = false)
    private BigDecimal subTotal;

}
