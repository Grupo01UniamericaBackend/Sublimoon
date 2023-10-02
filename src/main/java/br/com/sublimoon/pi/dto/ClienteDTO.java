package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

@Data
public class ClienteDTO extends AbstractEntityDTO {



    private String telefone;


    private String email;


    private String nome;


    private String senha;


    private String cpf;


    public ClienteDTO(String telefone, String email, String nome, String senha, String cpf) {
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }







    public ClienteDTO() {

    }
}
