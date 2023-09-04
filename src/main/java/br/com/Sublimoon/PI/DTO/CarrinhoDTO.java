package br.com.Sublimoon.PI.DTO;
import br.com.Sublimoon.PI.entity.AbstractEntity;
import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.entity.Item;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CarrinhoDTO extends AbstractEntity {


    private int quantidade;



    private float desconto;


    private float subTotal;


    private Cliente cliente;

    private List<Item> item;

}
