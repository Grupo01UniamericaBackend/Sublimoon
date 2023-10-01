package br.com.sublimoon.pi.DTO;

import br.com.sublimoon.pi.entity.AbstractEntity;
import br.com.sublimoon.pi.entity.Carrinho;
import br.com.sublimoon.pi.entity.Envio;
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
