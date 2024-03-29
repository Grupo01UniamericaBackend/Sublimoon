package br.com.sublimoon.pi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "pedidos",schema = "public")
public class Pedido extends AbstractEntity{


    @Getter @Setter
    @Column(name = "total")
    private float total;

    @Getter @Setter
    @Column(name = "pagamento",nullable = false,length = 15)
    private String pagamento;

    @Getter @Setter
    @Column(name = "endereço",nullable = false, length = 60)
    private String endereco;

    @Getter @Setter
    @Column(name = "cep",nullable = false,length = 25)
    private String cep;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "pedido_carrinho",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "pedido_id",
                            "carrinho_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "pedido_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "carrinho_id"
            )
    )
    private Carrinho carrinho;


    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "pedido_envio",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "pedido_id",
                            "envio_id"
                    }
            ),
            joinColumns = @JoinColumn(
                    name = "pedido_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "envio_id"
            )
    )
    private Envio envio;

    public Pedido (){}


    public Pedido(Long id,float total, String pagamento, String endereco, String cep, Carrinho carrinho, Envio envio) {
        this.id = id;
        this.total = total;
        this.pagamento = pagamento;
        this.endereco = endereco;
        this.cep = cep;
        this.carrinho = carrinho;
        this.envio = envio;
    }
}
