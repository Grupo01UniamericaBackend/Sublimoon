package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
abstract public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name="id", nullable = false, unique = true)
    protected Long id;
    @Getter @Setter
    @Column(name = "dtCadastro")
    private LocalDateTime cadastro;
    @Getter @Setter
    @Column(name = "dtEdicao")
    private LocalDateTime edicao;
    @Getter @Setter
    @Column (name = "ativo")
    private boolean ativo;

    @PrePersist
    private void prePersist(){
        this.cadastro = LocalDateTime.now();
        this.ativo = false;
    }

    @PreUpdate
    private void proUpdate(){
        this.edicao = LocalDateTime.now();
    }

}
