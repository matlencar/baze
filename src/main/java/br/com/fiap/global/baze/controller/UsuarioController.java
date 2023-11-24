package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.global.baze.excepions.RestNotFoundException;
import br.com.fiap.global.baze.model.Credencial;
import br.com.fiap.global.baze.model.Usuario;
import br.com.fiap.global.baze.repository.UsuarioRepository;
import br.com.fiap.global.baze.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    // injeção de dependencia
    @Autowired
    UsuarioRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());

        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }
    
    // Buscar por todas os ids
    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        log.info("Cadastrando um usuario" + usuario);
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {

        log.info("buscando um usuario por id" + id);

        return ResponseEntity.ok(getUsuario(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {

        log.info("Atualizando as informaçoes do usuario" + id);

            getUsuario(id);
           
            usuario.setId(id);
            repository.save(usuario);

            return ResponseEntity.ok(usuario);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id) {
        log.info("Deletando um usuario do sistema" + id);

            repository.delete(getUsuario(id));

            return ResponseEntity.noContent().build();
    }

    private Usuario getUsuario(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("telefone não encontrada"));
    }
}
