package br.com.sublimoon.pi.dto;

import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



public class FavoritoDTO extends AbstractEntityDTO{

    @Getter
    @Setter
    private List<Produto>produtos;

    @Getter @Setter
    private Cliente cliente;

    public FavoritoDTO(){

    }

    public FavoritoDTO(List<Produto>produtos,Cliente cliente){
        this.produtos = produtos;
        this.cliente = cliente;
    }

}
