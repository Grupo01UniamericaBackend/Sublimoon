package br.com.sublimoon.pi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;


@Entity

@Table(name = "configurações" , schema = "public")
public class Config extends AbstractEntity{

    @Getter @Setter
    @Column(name = "alterarNome")
    private String alterarNome;

    @Getter @Setter
    @Column(name = "alterarDescrição")
    private String alterarDescricao;


    @Getter @Setter
    @Column(name = "alterarPreço")
    private BigDecimal alterarPreco;

    @Getter @Setter
    @Column(name = "alterarQnt")
    private int alterarQnt;



}
