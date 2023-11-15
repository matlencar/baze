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
import br.com.fiap.global.baze.model.Corrida;
import br.com.fiap.global.baze.repository.CorridaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/corridas")
public class CorridaController {
    
     Logger log = LoggerFactory.getLogger(CorridaController.class);

    // injeção de dependencia
    @Autowired
    CorridaRepository repository;
    
    // Buscar por todas as bicicletas
    @GetMapping
    public List<Corrida> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Corrida> create(@RequestBody @Valid Corrida corrida) {
        log.info("Cadastrando uma corrida" + corrida);

        repository.save(corrida);

        return ResponseEntity.status(HttpStatus.CREATED).body(corrida);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Corrida> show(@PathVariable Integer id) {

        log.info("buscando uma corrida feita por id" + id);

        return ResponseEntity.ok(getCorrida(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Corrida> update(@PathVariable Integer id, @RequestBody @Valid Corrida corrida) {

        log.info("Atualizando as informaçoes da corrida feita" + id);

            getCorrida(id);
           
            corrida.setId(id);
            repository.save(corrida);

            return ResponseEntity.ok(corrida);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Corrida> destroy(@PathVariable Integer id) {
        log.info("Deletando uma corrida do sistema" + id);

            repository.delete(getCorrida(id));

            return ResponseEntity.noContent().build();
    }

    private Corrida getCorrida(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("corrida não encontrada"));
    }
}
