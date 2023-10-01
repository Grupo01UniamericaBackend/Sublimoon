package br.com.sublimoon.pi.DTO;

import lombok.Data;



@Data
public class AdmDTO extends UsuarioDTO {


    private String userAdm;


    private String senhaAdm;


    public AdmDTO(String userAdm, String senhaAdm) {
    }


    public AdmDTO(String userAdm, String senhaAdm, String telefone, String email) {
    }

    public AdmDTO() {

    }
}
