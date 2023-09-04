package br.com.Sublimoon.PI.DTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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



}
