package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Corrida;

@RestController
public class CorridaController {
    
     @GetMapping("api/corrida")
    public Corrida show() {
        return new Corrida(1, 5.00, 12.00);
    }
}
