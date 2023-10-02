package br.com.sublimoon.pi.dto;
import br.com.sublimoon.pi.entity.Categoria;
import br.com.sublimoon.pi.entity.Cor;
import lombok.Getter;
import lombok.Setter;


public class ProdutoDTO extends AbstractEntityDTO {

    @Getter
    @Setter
    private String nome;
    @Getter @Setter
    private Categoria categoria;
    @Getter @Setter
    private Cor cor;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private String imagem;

    @Getter @Setter
    private float preco;

    @Getter @Setter
    private float quantidade;
    @Getter @Setter
    private float mediaAvaliacao;

    @Getter @Setter
    private String tamanho;

    @SuppressWarnings("java:S107")
    public ProdutoDTO(String nome, Categoria categoria, Cor cor, String descricao, String imagem, float preco, float quantidade, float mediaAvaliacao, String tamanho) {
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

    public ProdutoDTO() {

    }
}
