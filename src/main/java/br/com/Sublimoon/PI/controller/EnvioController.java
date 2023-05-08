package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/envio")
public class EnvioController {

    @Autowired
    EnvioRepository envioRepository;
}
