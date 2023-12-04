package br.com.sublimoon.pi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String role;

    private String password;
    private String token;

}
