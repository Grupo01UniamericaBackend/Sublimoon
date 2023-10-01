package br.com.Sublimoon.pi.DTO;

import br.com.Sublimoon.pi.entity.AbstractEntity;
import lombok.Data;

@Data
public class ClienteDTO extends AbstractEntity {



    private String telefone;


    private String email;


    private String nome;


    private String senha;


    private String cpf;


    public ClienteDTO(String telefone, String email, String nome, String senha, String cpf) {
        super();
    }

    public ClienteDTO() {

    }
}
