package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Bicicleta;

@RestController
public class BicicletaController {
    
     @GetMapping("api/bicicleta")
    public Bicicleta show() {
        return new Bicicleta(1, "14", 12, "40kg", "Vermelha", "Profissional", 5);
    }
}
