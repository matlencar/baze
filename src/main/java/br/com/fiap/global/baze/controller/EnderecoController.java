package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Endereco;

@RestController
public class EnderecoController {
    
    @GetMapping("api/endereco")
    public Endereco show() {
        return new Endereco(1, "Lins de vasconcelos",  1200, "Aclimacao", "São Paulo", "Brasil", "0411199", "FIAP");
    }
}
