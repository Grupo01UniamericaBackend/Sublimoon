package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table (name = "produtos",schema = "public")
public class Produto  extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "produto", nullable = false, unique = true, length = 100)
    private String nome;

   /* @Getter @Setter
    @Column (name = "catId")
    private Long idCat;*/


    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @Column(name = "categoria", length = 15, nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @Column(name = "cor", length = 15, nullable = false)
    private Cor cor;

    @Getter
    @Setter
    @Column(name = "descrição", length = 500, nullable = false)
    private String descricao;

    @Getter
    @Setter
    @Column(name = "imagem", length = 500)
    private String imagem;

    @Getter
    @Setter
    @Column(name = "preço", nullable = false)
    private float preco;

    @Getter
    @Setter
    @Column(name = "quantidadeEstoque", nullable = false)
    private float quantidade;

   /* @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_avaliacao",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "produto_id",
                            "avaliacao_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "produto_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "avaliacao_id"
            )
    )
    private List<Avaliacao> avaliacoes;*/



    @Getter
    @Setter
    @Column(name = "mediaAvaliacao")
    private float mediaAvaliacao;

   /* @Getter @Setter
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
    private Favorito favoritos;*/


    @Getter
    @Setter
    @Column(name = "tamanhoDoProduto", nullable = false, length = 10)
    private String tamanho;

    /*@Getter @Setter
    @Column(name = "quantidadeProCarrinho")
    private int quantidadeProCarrinho;*/

}
