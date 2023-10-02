package br.com.sublimoon.pi.dto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idUsuario",nullable = false, unique = true)
    private Long id;

    private LocalDateTime cadastro;

    private LocalDateTime edicao;

    private boolean ativo;
    private String telefone;

    private String email;


    public UsuarioDTO() {

    }

    public UsuarioDTO(Long id, LocalDateTime cadastro, LocalDateTime edicao, boolean ativo, String telefone, String email) {
        this.id = id;
        this.cadastro = cadastro;
        this.edicao = edicao;
        this.ativo = ativo;
        this.telefone = telefone;
        this.email = email;
    }
}
