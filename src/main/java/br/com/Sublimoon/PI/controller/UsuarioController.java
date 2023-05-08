package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
}
