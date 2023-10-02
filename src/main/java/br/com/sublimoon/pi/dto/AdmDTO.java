package br.com.sublimoon.pi.dto;

import lombok.Data;



@Data
public class AdmDTO extends UsuarioDTO {


    private String userAdm;


    private String senhaAdm;


    public AdmDTO(String userAdm, String senhaAdm) {
        this.userAdm = userAdm;
        this.senhaAdm = senhaAdm;
    }

    public AdmDTO() {

    }
}
