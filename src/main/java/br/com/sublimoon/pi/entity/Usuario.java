package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public class  Usuario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idUsuario",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "dtCadastro")
    private LocalDateTime cadastro;
    @Getter @Setter
    @Column(name = "dtEdicao")
    private LocalDateTime edicao;
    @Getter @Setter
    @Column (name = "ativo")
    private boolean ativo;


    @Getter @Setter
    @Column(name = "telefone",nullable = false,length = 40)
    private String telefone;

    @Getter @Setter
    @Column (name = "email",nullable = false,length = 50)
    private String email;

    @PrePersist
    private void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.ativo = true;
    }

    @PreUpdate
    private void proUpdate(){
        this.edicao = LocalDateTime.now();
    }


    public Usuario() {
    }

    public Usuario(Long id, LocalDateTime cadastro, LocalDateTime edicao, boolean ativo, String telefone, String email) {
        this.id = id;
        this.cadastro = cadastro;
        this.edicao = edicao;
        this.ativo = ativo;
        this.telefone = telefone;
        this.email = email;
    }
}
