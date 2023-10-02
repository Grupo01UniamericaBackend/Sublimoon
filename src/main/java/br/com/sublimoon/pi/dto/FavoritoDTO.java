package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Produto;
import lombok.Data;

import java.util.List;


@Data
public class FavoritoDTO extends AbstractEntityDTO{



    private List<Produto>produtos;


    private Cliente cliente;

    public FavoritoDTO(){

    }

    public FavoritoDTO(List<Produto>produtos,Cliente cliente){
        this.produtos = produtos;
        this.cliente = cliente;
    }

}
