package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
public class ItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name="id", nullable = false, unique = true)
    private Long id;

    private Produto produto;

    private int quantidade; 

    private float valor;

    private float valorUnit;

    private float valorTotal = valorUnit * quantidade;

    public ItemDTO(){}

    public ItemDTO( Produto produto, int quantidade, float valor, float valorUnit,float valorTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.valorUnit = valorUnit;
        this.valorTotal = valorTotal;
    }
}
