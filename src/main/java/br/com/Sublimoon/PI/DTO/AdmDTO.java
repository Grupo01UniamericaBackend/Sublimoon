package br.com.Sublimoon.PI.DTO;

import br.com.Sublimoon.PI.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class AdmDTO extends UsuarioDTO {


    private String userAdm;


    private String senhaAdm;


}
