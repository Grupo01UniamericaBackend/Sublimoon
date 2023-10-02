package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "produtos",schema = "public")
public class Produto  extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "produto", nullable = false, unique = true, length = 100)
    private String nome;

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


    @Getter
    @Setter
    @Column(name = "mediaAvaliacao")
    private float mediaAvaliacao;

    @Getter
    @Setter
    @Column(name = "tamanhoDoProduto", nullable = false, length = 10)
    private String tamanho;

    @SuppressWarnings("java:S107")
    public Produto(String nome, Categoria categoria, Cor cor, String descricao, String imagem, float preco, float quantidade, float mediaAvaliacao, String tamanho) {
        this.nome = nome;
        this.categoria = categoria;
        this.cor = cor;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.quantidade = quantidade;
        this.mediaAvaliacao = mediaAvaliacao;
        this.tamanho = tamanho;
    }

    public Produto() {

    }
    public Produto(Long id ,String nome, Categoria categoria, Cor cor, String descricao, String imagem, float preco, float quantidade, float mediaAvaliacao, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.cor = cor;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.quantidade = quantidade;
        this.mediaAvaliacao = mediaAvaliacao;
        this.tamanho = tamanho;
    }

    public Produto(Long id,String nome) {
        this.id = id;
        this.nome = nome;
    }
}
