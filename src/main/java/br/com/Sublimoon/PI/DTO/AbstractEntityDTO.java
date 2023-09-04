package br.com.Sublimoon.PI.DTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
abstract public class AbstractEntityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name="id", nullable = false, unique = true)
    private Long id;


    private LocalDateTime cadastro;

    private LocalDateTime edicao;

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
