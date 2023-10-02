package br.com.sublimoon.pi.dto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
 public abstract class AbstractEntityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name="id", nullable = false, unique = true)
    private Long id;


    private LocalDateTime cadastro;

    private LocalDateTime edicao;

    private boolean ativo;



}
