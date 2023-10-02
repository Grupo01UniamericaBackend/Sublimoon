package br.com.sublimoon.pi.dto;
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


    public CarrinhoDTO(int quantidade, float desconto, float subTotal, Cliente cliente, List<Item> item) {
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.subTotal = subTotal;
        this.cliente = cliente;
        this.item = item;
    }

    public CarrinhoDTO(float desconto, float subTotal, Cliente cliente, List<Item> item) {
        this.desconto = desconto;
        this.subTotal = subTotal;
        this.cliente = cliente;
        this.item = item;
    }
}
