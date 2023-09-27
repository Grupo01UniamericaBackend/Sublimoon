package br.com.sublimoon.pi.DTO;

import br.com.sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConfigDTO extends AbstractEntity {


    private String alterarNome;


    private String alterarDescricao;



    private BigDecimal alterarPreco;


    private int alterarQnt;



}
