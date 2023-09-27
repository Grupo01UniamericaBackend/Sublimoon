package br.com.sublimoon.pi.dto;
import br.com.sublimoon.pi.entity.AbstractEntity;
import br.com.sublimoon.pi.entity.Categoria;
import br.com.sublimoon.pi.entity.Cor;
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


}
