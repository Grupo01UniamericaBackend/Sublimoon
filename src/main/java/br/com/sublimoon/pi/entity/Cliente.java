package br.com.sublimoon.pi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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


    public Cliente() {
    }

    public Cliente(Long id,String telefone, String email, String nome, String senha, String cpf) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }
}
