package br.com.sublimoon.pi.dto;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Item;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CarrinhoDTO extends AbstractEntityDTO {




    @Getter @Setter
    private float desconto;

    @Getter @Setter
    private float subTotal;

    @Getter @Setter
    private Cliente cliente;
    @Getter @Setter
    private List<Item> item;


    public CarrinhoDTO(float desconto, float subTotal, Cliente cliente, List<Item> item) {
        this.desconto = desconto;
        this.subTotal = subTotal;
        this.cliente = cliente;
        this.item = item;
    }


    public CarrinhoDTO() {

    }
}