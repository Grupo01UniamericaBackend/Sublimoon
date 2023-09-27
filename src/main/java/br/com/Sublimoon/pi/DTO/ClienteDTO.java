package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

@Data
public class ClienteDTO extends AbstractEntity {



    private String telefone;


    private String email;


    private String nome;


    private String senha;


    private String cpf;



}
