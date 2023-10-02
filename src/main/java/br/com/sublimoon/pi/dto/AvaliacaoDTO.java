package br.com.sublimoon.pi.dto;


import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Produto;
import lombok.Getter;
import lombok.Setter;



public class AvaliacaoDTO extends AbstractEntityDTO {


    @Getter @Setter
    private Float nota;

    @Getter @Setter
    private String comentario;


    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Produto produto;


    public AvaliacaoDTO(float nota, String comentario, Cliente cliente, Produto produto) {
        this.nota = nota;
        this.comentario = comentario;
        this.cliente = cliente;
        this.produto = produto;
    }

    public AvaliacaoDTO() {

    }

    public AvaliacaoDTO(Float nota, Cliente cliente, Produto produto) {
        this.nota = nota;
        this.cliente = cliente;
        this.produto = produto;
    }
}
