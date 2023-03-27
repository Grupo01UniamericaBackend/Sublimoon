package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Adms",schema = "public")
public class Adm extends Usuario{

    @Getter @Setter
    @Column (name = "userAdm",nullable = false,length = 25)
    private String userAdm;

    @Getter @Setter
    @Column(name = "senhaAdm",nullable = false,length = 20)
    private String senhaAdm;

}
