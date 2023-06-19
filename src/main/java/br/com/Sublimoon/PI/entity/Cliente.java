package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Clientes",schema = "public")
public class Cliente extends AbstractEntity{


    @Getter @Setter
    @Column(name = "telefone",nullable = false,unique = true,length = 40)
    private String telefone;

    @Getter @Setter
    @Column (name = "email",nullable = false,unique = true,length = 50)
    private String email;


    @Getter @Setter
    @Column(name = "nomeCliente",nullable = false,length = 45)
    private String nome;

    @Getter @Setter
    @Column(name = "senha",nullable = false,length = 40)
    private String senha;

    @Getter @Setter
    @Column(name = "cpf",nullable = false,unique = true,length = 30)
    private String cpf;

   /* @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cliente_avaliacao",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "cliente_id",
                            "avaliacao_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "cliente_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "avaliacao_id"


            )

    )
    private List<Avaliacao> avaliacoesCliente;*/

}
