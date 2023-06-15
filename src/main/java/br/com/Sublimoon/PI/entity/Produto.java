package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "produtos",schema = "public")
public class Produto  extends AbstractEntity {

    @Getter @Setter
    @Column (name = "produto", nullable = false, unique = true,length = 100)
    private String nome;

   /* @Getter @Setter
    @Column (name = "catId")
    private Long idCat;*/

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY)
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
    @Column(name = "cor", length = 15, nullable = false)
    private Cor cor;

    @Getter @Setter
    @Column(name = "descrição", length = 500, nullable = false )
    private String descricao;

    @Getter @Setter
    @Column(name = "imagem", length = 500)
    private String imagem;

    @Getter @Setter
    @Column(name = "preço", nullable = false)
    private float preco;

    @Getter @Setter
    @Column(name = "quantidade",nullable = false)
    private int quantidade;

    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY)
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
    )
    private List<Avaliacao> avaliavao;

    @Getter @Setter
    @Column (name = "pesoProduto",nullable = false)
    private float pesoProduto;

    @Getter @Setter
    @Column (name = "mediaAvaliacao",nullable = false)
    private float mediaAvaliacao;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
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
    private Favorito favoritos;


    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "produtos")
    private List<Carrinho> carrinhos;


    @Getter @Setter
    @Column(name = "tamanhoDoProduto",nullable = false,length = 10)
    private String tamanho;



}
