package br.com.sublimoon.pi.DTO;


import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Produto;
import lombok.Data;



@Data
public class AvaliacaoDTO extends AbstractEntityDTO {



    private Float nota;



    private String comentario;



    private Cliente cliente;


    private Produto produto;




}
