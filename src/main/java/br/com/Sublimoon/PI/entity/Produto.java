package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "produtos",schema = "public")
public class Produto {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idProduto",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column (name = "produto", nullable = false, unique = true,length = 100)
    private String nome;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "produto_categoria",
    uniqueConstraints = @UniqueConstraint(
            columnNames = {
            "produto_id",
            "categoria_id"
    }
    ),
            joinColumns = @JoinColumn(
                name = "produto_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "categoria_id"
            )

    )
    private List<Categoria> categorias;

    @Enumerated (EnumType.STRING)
    @Getter @Setter
    @Column(name = "tipo", length = 15, nullable = false)
    private Cor cor;

    @Getter @Setter
    @Column(name = "descrição", length = 500, nullable = false )
    private String descricao;

    @Getter @Setter
    @Column(name = "imagem", length = 500)
    private String imagem;

    @Getter @Setter
    @Column(name = "preço", nullable = false)
    private BigDecimal preco;

    @Getter @Setter
    @Column(name = "quantidade",nullable = false)
    private int quantidade;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "produto_avaliação",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "produto_id",
                            "avaliação_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "produto_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "avaliação_id"
            )
    )    private List<Avaliacao> avaliavao;

    @Getter @Setter
    @Column (name = "pesoProduto",nullable = false)
    private BigDecimal pesoproduto;

    @Getter @Setter
    @Column (name = "médiaAvaliação",nullable = false)
    private float mediaAvaliacao;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "produto_favoritos",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "produto_id",
                            "favorito_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "produto_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "favorito_id"
            )

    )
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Favorito favoritos;

    @Getter @Setter
    @Column(name = "tamanhoDoProduto",nullable = false,length = 4)
    private String tamanho;



}
