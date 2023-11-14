package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.global.baze.model.Registro;

@RestController
public class RegistroController {
    
     @GetMapping("api/registro")
    public Registro show() {
        return new Registro(1, "12:30");
    }
}
