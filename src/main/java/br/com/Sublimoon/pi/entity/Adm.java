package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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
