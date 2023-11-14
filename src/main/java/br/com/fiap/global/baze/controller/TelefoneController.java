package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Telefone;

@RestController
public class TelefoneController {
    
     @GetMapping("api/telefone")
    public Telefone show() {
        return new Telefone(1, "976751413", 011, 55);
    }
}
