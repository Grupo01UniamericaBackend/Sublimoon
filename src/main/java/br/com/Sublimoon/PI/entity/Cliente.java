package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Clientes",schema = "public")
public class Cliente{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idCliente",nullable = false, unique = true)
    private Long id;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Favoritos")
    private Favorito favoritos;

    @Getter @Setter
    @Column(name = "telefone",nullable = false,unique = true,length = 40)
    private String telefone;

    @Getter @Setter
    @Column (name = "email",nullable = false,unique = true,length = 50)
    private String email;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @Getter @Setter
    @Column(name = "nomeCliente",nullable = false,length = 45)
    private String nome;

    @Getter @Setter
    @Column(name = "senha",nullable = false,length = 40)
    private String senha;

    @Getter @Setter
    @Column(name = "cpf",nullable = false,unique = true,length = 30)
    private String cpf;

    @Getter @Setter
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes;

}
