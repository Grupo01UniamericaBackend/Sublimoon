package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ClienteDTO extends AbstractEntity {



    private String telefone;


    private String email;


    private String nome;


    private String senha;


    private String cpf;



}
