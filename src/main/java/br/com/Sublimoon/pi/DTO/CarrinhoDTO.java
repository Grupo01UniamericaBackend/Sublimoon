package br.com.Sublimoon.pi.DTO;
import br.com.Sublimoon.pi.entity.AbstractEntity;
import br.com.Sublimoon.pi.entity.Cliente;
import br.com.Sublimoon.pi.entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class CarrinhoDTO extends AbstractEntity {


    private int quantidade;



    private float desconto;


    private float subTotal;


    private Cliente cliente;

    private List<Item> item;

}
