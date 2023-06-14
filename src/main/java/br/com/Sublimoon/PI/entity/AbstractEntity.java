package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="id", nullable = false, unique = true)
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

    @PrePersist
    private void prePersist(){
        this.cadastro = LocalDateTime.now();
    }

    @PreUpdate
    private void proUpdate(){
        this.edicao = LocalDateTime.now();
    }





    public Long getId() {
        return id;
    }

}
