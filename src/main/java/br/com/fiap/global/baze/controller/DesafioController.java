package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Desafio;



@RestController
public class DesafioController {
    
    @GetMapping("api/desafio")
    public Desafio show() {
        return new Desafio(1, "Pedale 2 Kms", "O ciclista devera pedalar 2 kms para completar o desafio", "20", "Cupom de 40 R$ de desconto na decathlon");
    }
}
