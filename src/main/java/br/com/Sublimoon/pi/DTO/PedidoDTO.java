package br.com.Sublimoon.pi.DTO;

import br.com.Sublimoon.pi.entity.AbstractEntity;
import br.com.Sublimoon.pi.entity.Carrinho;
import br.com.Sublimoon.pi.entity.Envio;
import lombok.Data;

@Data
public class PedidoDTO extends AbstractEntity {



    private float total;


    private String pagamento;


    private String endereco;


    private String cep;

    private Carrinho carrinho;


    private Envio envio;


}
