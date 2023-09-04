package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import br.com.Sublimoon.PI.entity.Carrinho;
import br.com.Sublimoon.PI.entity.Envio;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PedidoDTO extends AbstractEntity {



    private float total;


    private String pagamento;


    private String endereco;


    private String cep;

    private Carrinho carrinho;


    private Envio envio;


}
