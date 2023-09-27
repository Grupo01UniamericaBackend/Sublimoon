package br.com.Sublimoon.pi.DTO;


import br.com.Sublimoon.pi.entity.Cliente;
import br.com.Sublimoon.pi.entity.Produto;
import lombok.Data;



@Data
public class AvaliacaoDTO extends AbstractEntityDTO {



    private Float nota;



    private String comentario;



    private Cliente cliente;


    private Produto produto;




}
