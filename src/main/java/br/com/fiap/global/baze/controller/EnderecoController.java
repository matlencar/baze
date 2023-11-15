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
import br.com.fiap.global.baze.model.Endereco;

import br.com.fiap.global.baze.repository.EnderecoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
    
    Logger log = LoggerFactory.getLogger(EnderecoController.class);

    // injeção de dependencia
    @Autowired
    EnderecoRepository repository;
    
    // Buscar por todas as bicicletas
    @GetMapping
    public List<Endereco> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody @Valid Endereco endereco) {
        log.info("Cadastrando um endereco" + endereco);

        repository.save(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Endereco> show(@PathVariable Long id) {

        log.info("buscando um endereco por id" + id);

        return ResponseEntity.ok(getEndereco(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody @Valid Endereco endereco) {

        log.info("Atualizando as informaçoes do endereco" + id);

            getEndereco(id);
            endereco.setId(id);
            repository.save(endereco);

            return ResponseEntity.ok(endereco);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Endereco> destroy(@PathVariable Long id) {
        log.info("Deletando um endereco do sistema" + id);

            repository.delete(getEndereco(id));

            return ResponseEntity.noContent().build();
    }

    private Endereco getEndereco(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("endereço não encontrada"));
    }
}
