package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.AbstractEntity;
import br.com.Sublimoon.PI.entity.Cliente;
import br.com.Sublimoon.PI.entity.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class FavoritoDTO extends AbstractEntity {



    private List<Produto>produtos;


    private Cliente cliente;

}
