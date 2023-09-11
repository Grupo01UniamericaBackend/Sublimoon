package br.com.Sublimoon.PI.DTO;
import br.com.Sublimoon.PI.entity.AbstractEntity;
import br.com.Sublimoon.PI.entity.Categoria;
import br.com.Sublimoon.PI.entity.Cor;
import jakarta.persistence.*;
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
