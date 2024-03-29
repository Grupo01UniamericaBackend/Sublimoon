package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Table(name = "Adms",schema = "public")
public class Adm extends AbstractEntity{

    @Getter @Setter
    @Column (name = "userAdm",nullable = false,length = 25)
    private String userAdm;

    @Getter @Setter
    @Column(name = "senhaAdm",nullable = false,length = 20)
    private String senhaAdm;


    public Adm(Long id,String userAdm, String senhaAdm) {
        this.id = id;
        this.userAdm = userAdm;
        this.senhaAdm = senhaAdm;
    }
}
