package br.com.Sublimoon.PI.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "pedidos",schema = "public")
public class Pedido extends Carrinho{

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "Envio",nullable = false)
    private Envio envio;

    @Getter @Setter
    @Column(name = "total",nullable = false)
    private BigDecimal total;

    @Getter @Setter
    @Column(name = "pagamento",nullable = false,length = 15)
    private String pagamento;

    @Getter @Setter
    @Column(name = "endereço",nullable = false, length = 60)
    private String endereco;

    @Getter @Setter
    @Column(name = "cep",nullable = false,length = 25)
    private String cep;







}
