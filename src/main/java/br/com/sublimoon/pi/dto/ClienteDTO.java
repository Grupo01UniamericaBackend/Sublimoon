package br.com.sublimoon.pi.dto;

import lombok.Getter;
import lombok.Setter;


public class ClienteDTO extends AbstractEntityDTO {


    @Getter
    @Setter
    private String telefone;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String senha;

    @Getter @Setter
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
