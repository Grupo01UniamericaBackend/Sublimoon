package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.entity.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class AvaliacaoDTO extends AbstractEntityDTO {



    private Float nota;



    private String comentario;



    private Cliente cliente;


    private Produto produto;




}
