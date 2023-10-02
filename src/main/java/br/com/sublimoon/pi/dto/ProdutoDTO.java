package br.com.sublimoon.pi.dto;
import br.com.sublimoon.pi.entity.Categoria;
import br.com.sublimoon.pi.entity.Cor;
import lombok.Data;

@Data
public class ProdutoDTO extends AbstractEntityDTO {


    private String nome;

    private Categoria categoria;

    private Cor cor;


    private String descricao;


    private String imagem;


    private float preco;


    private float quantidade;

    private float mediaAvaliacao;


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
