package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Produto;
import lombok.Getter;
import lombok.Setter;

public class ItemDTO extends AbstractEntityDTO{

    @Getter @Setter
    private Produto produto;

    @Getter @Setter
    private int quantidade;
    @Getter @Setter
    private float valor;
    @Getter @Setter
    private float valorUnit;
    @Getter @Setter
    private float valorTotal = valorUnit * quantidade;

    public ItemDTO(){}

    public ItemDTO(Produto produto, int quantidade, float valor, float valorUnit,float valorTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
    }
}
