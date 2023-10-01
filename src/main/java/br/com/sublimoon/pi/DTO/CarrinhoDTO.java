package br.com.sublimoon.pi.DTO;
import br.com.sublimoon.pi.entity.AbstractEntity;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Item;
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
