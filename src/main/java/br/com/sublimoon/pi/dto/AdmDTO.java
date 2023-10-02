package br.com.sublimoon.pi.dto;

import lombok.Getter;
import lombok.Setter;

public class AdmDTO extends UsuarioDTO {

    @Getter @Setter
    private String userAdm;

    @Getter @Setter
    private String senhaAdm;


    public AdmDTO(String userAdm, String senhaAdm) {
        this.userAdm = userAdm;
        this.senhaAdm = senhaAdm;
    }

    public AdmDTO() {

    }
}
