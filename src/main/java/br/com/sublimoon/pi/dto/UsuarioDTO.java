package br.com.sublimoon.pi.dto;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;


public class UsuarioDTO extends AbstractEntityDTO{

    @Getter @Setter
    private LocalDateTime cadastro;

    @Getter @Setter
    private LocalDateTime edicao;
    @Getter @Setter
    private boolean ativo;

    @Getter @Setter
    private String telefone;

    @Getter @Setter
    private String email;


    public UsuarioDTO() {

    }

    public UsuarioDTO(LocalDateTime cadastro, LocalDateTime edicao, boolean ativo, String telefone, String email) {
        this.cadastro = cadastro;
        this.edicao = edicao;
        this.ativo = ativo;
        this.telefone = telefone;
        this.email = email;
    }
}
