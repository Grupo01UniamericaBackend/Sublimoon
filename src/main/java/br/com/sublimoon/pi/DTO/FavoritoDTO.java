package br.com.sublimoon.pi.DTO;

import br.com.sublimoon.pi.entity.AbstractEntity;
import br.com.sublimoon.pi.entity.Cliente;
import br.com.sublimoon.pi.entity.Produto;
import lombok.Data;

import java.util.List;


@Data
public class FavoritoDTO extends AbstractEntity {



    private List<Produto>produtos;


    private Cliente cliente;

}
