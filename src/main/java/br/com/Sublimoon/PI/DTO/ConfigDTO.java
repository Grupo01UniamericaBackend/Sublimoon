package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity

@Table(name = "configurações" , schema = "public")
public class ConfigDTO extends AbstractEntity {

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
