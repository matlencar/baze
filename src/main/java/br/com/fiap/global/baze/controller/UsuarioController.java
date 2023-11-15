package br.com.fiap.global.baze.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.global.baze.model.Usuario;
import br.com.fiap.global.baze.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    // injeção de dependencia
    @Autowired
    UsuarioRepository repository;
    
    // Buscar por todas os ids
    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("Cadastrando um usuario" + usuario);

        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Integer id) {

        log.info("buscando um usuario por id" + id);
        var buscarUsuario = repository.findById(id);
        
        if(buscarUsuario.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(buscarUsuario.get());
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {

        log.info("Atualizando as informaçoes do usuario" + id);

        var buscarUsuarioUpdate = repository.findById(id);

        if (buscarUsuarioUpdate.isEmpty())
            return ResponseEntity.notFound().build();
           
            usuario.setId(id);
            repository.save(usuario);

            return ResponseEntity.ok(usuario);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Integer id) {
        log.info("Deletando um usuario do sistema" + id);
        var buscarUsuarioDelete = repository.findById(id);

        if(buscarUsuarioDelete.isEmpty())
            return ResponseEntity.notFound().build();;

            repository.delete(buscarUsuarioDelete.get());

            return ResponseEntity.noContent().build();
    }
}
