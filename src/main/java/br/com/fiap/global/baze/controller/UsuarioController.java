package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Usuario;

@RestController
public class UsuarioController {
    
    @GetMapping("api/usuario")
    public Usuario show() {
        return new Usuario(1, "Matheus", "malencar292@gmail.com", "ola", 29, 55.0, 1.72, "435552181", "99943122290","A", "M");
    }
}
