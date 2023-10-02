package br.com.sublimoon.pi.dto;

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

    public PedidoDTO(){}

    public PedidoDTO(float total, String pagamento, String endereco, String cep, Carrinho carrinho, Envio envio) {
        this.total = total;
        this.pagamento = pagamento;
        this.endereco = endereco;
        this.cep = cep;
        this.carrinho = carrinho;
        this.envio = envio;
    }
}
