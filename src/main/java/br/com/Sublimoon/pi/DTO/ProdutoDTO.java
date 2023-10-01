package br.com.Sublimoon.pi.DTO;
import br.com.Sublimoon.pi.entity.AbstractEntity;
import br.com.Sublimoon.pi.entity.Categoria;
import br.com.Sublimoon.pi.entity.Cor;
import lombok.Data;

@Data
public class ProdutoDTO extends AbstractEntity {


    private String nome;

    private Categoria categoria;

    private Cor cor;


    private String descricao;


    private String imagem;


    private float preco;


    private float quantidade;

    private float mediaAvaliacao;


    private String tamanho;


    public ProdutoDTO(String nome, Categoria categoria, Cor cor, String descricao, String imagem, float preco, int quantidade, int mediaAvaliacao, String tamanho) {
        super();
    }
}
