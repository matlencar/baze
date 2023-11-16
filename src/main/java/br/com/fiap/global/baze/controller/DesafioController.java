package br.com.fiap.global.baze.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import br.com.fiap.global.baze.excepions.RestNotFoundException;
import br.com.fiap.global.baze.model.Desafio;
import br.com.fiap.global.baze.repository.DesafioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/desafios")
public class DesafioController {

    Logger log = LoggerFactory.getLogger(DesafioController.class);

    // injeção de dependencia
    @Autowired
    DesafioRepository repository;
    
    // Buscar por todos os desafios
    @GetMapping
    public Page<Desafio> index(@RequestParam(required = false) String descricao, @PageableDefault(size = 5) Pageable pageable) {

        if (descricao == null)
            return repository.findAll(pageable);

        return repository.findByDescricaoContaining(descricao, pageable);
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Desafio> create(@RequestBody @Valid Desafio desafio) {
        log.info("Cadastrando um desafio" + desafio);
        repository.save(desafio);
        return ResponseEntity.status(HttpStatus.CREATED).body(desafio);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Desafio> show(@PathVariable Long id) {
        log.info("buscando desafio por id" + id);
        return ResponseEntity.ok(getDesafio(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Desafio> update(@PathVariable Long id, @RequestBody @Valid Desafio desafio) {

        log.info("Atualizando o desafio" + id);
        getDesafio(id);
           
            desafio.setId(id);
            repository.save(desafio);

            return ResponseEntity.ok(desafio);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Desafio> destroy(@PathVariable Long id) {
        log.info("Deletando um desafio" + id);

            repository.delete(getDesafio(id));

            return ResponseEntity.noContent().build();
    }

    private Desafio getDesafio(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("desafio não encontrada"));
    }
}
