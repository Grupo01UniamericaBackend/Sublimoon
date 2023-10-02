package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Carrinho;
import br.com.sublimoon.pi.entity.Envio;
import lombok.Getter;
import lombok.Setter;


public class PedidoDTO extends AbstractEntityDTO {


    @Getter
    @Setter
    private float total;

    @Getter @Setter
    private String pagamento;

    @Getter @Setter
    private String endereco;

    @Getter @Setter
    private String cep;
    @Getter @Setter
    private Carrinho carrinho;

    @Getter @Setter
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
