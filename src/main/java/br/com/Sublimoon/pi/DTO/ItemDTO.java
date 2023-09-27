package br.com.Sublimoon.pi.DTO;

import br.com.Sublimoon.pi.entity.Produto;
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

    private float ValorTotal = valorUnit * quantidade;
}
