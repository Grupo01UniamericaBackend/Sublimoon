package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
public class ConfigDTO extends AbstractEntity {


    private String alterarNome;


    private String alterarDescricao;



    private BigDecimal alterarPreco;


    private int alterarQnt;



}
