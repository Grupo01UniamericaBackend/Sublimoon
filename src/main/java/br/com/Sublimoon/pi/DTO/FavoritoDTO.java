package br.com.Sublimoon.pi.DTO;

import br.com.Sublimoon.pi.entity.AbstractEntity;
import br.com.Sublimoon.pi.entity.Cliente;
import br.com.Sublimoon.pi.entity.Produto;
import lombok.Data;

import java.util.List;


@Data
public class FavoritoDTO extends AbstractEntity {



    private List<Produto>produtos;


    private Cliente cliente;

}
