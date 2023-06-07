package br.com.Sublimoon.PI.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Clientes",schema = "public")
public class Cliente extends Usuario{

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Favoritos")
    private Favorito favorito;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

}
