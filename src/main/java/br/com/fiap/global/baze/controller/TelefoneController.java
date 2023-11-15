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

import br.com.fiap.global.baze.excepions.RestNotFoundException;
import br.com.fiap.global.baze.model.Telefone;
import br.com.fiap.global.baze.repository.TelefoneRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {
    
     Logger log = LoggerFactory.getLogger(TelefoneController.class);

    // injeção de dependencia
    @Autowired
    TelefoneRepository repository;
    
    // Buscar por todas os ids
    @GetMapping
    public List<Telefone> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone) {
        log.info("Cadastrando um telefone" + telefone);

        repository.save(telefone);

        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Telefone> show(@PathVariable Integer id) {

        log.info("buscando um telefone por id" + id);

        return ResponseEntity.ok(getTelefone(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Telefone> update(@PathVariable Integer id, @RequestBody @Valid Telefone telefone) {

        log.info("Atualizando as informaçoes do Telefone" + id);

            getTelefone(id);

            telefone.setId(id);
            repository.save(telefone);

            return ResponseEntity.ok(telefone);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Telefone> destroy(@PathVariable Integer id) {
        log.info("Deletando um telefone do sistema" + id);

            repository.delete(getTelefone(id));

            return ResponseEntity.noContent().build();
    }

    private Telefone getTelefone(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("telefone não encontrada"));
    }
}
