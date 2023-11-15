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
import br.com.fiap.global.baze.model.Bicicleta;
import br.com.fiap.global.baze.repository.BicicletaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/bicicletas")
public class BicicletaController {
    
    Logger log = LoggerFactory.getLogger(BicicletaController.class);

    // injeção de dependencia
    @Autowired
    BicicletaRepository repository;
    
    // Buscar por todas as bicicletas
    @GetMapping
    public List<Bicicleta> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Bicicleta> create(@RequestBody @Valid Bicicleta bike) {
        log.info("Cadastrando uma bicicleta" + bike);

        repository.save(bike);

        return ResponseEntity.status(HttpStatus.CREATED).body(bike);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Bicicleta> show(@PathVariable Integer id) {

        log.info("buscando bicicleta por id" + id);

        return ResponseEntity.ok(getBicicleta(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Bicicleta> update(@PathVariable Integer id, @RequestBody @Valid Bicicleta bike) {

        log.info("Atualizando as informaçoes da bicicleta" + id);

            getBicicleta(id);
           
            bike.setId(id);
            repository.save(bike);

            return ResponseEntity.ok(bike);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Bicicleta> destroy(@PathVariable Integer id) {
        log.info("Deletando uma bicicleta" + id);

            repository.delete(getBicicleta(id));

            return ResponseEntity.noContent().build();
    }

    private Bicicleta getBicicleta(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("bicicleta não encontrada"));
    }
}
