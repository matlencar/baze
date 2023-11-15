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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.global.baze.model.Desafio;
import br.com.fiap.global.baze.repository.DesafioRepository;

@RestController
@RequestMapping("/api/desafios")
public class DesafioController {

    Logger log = LoggerFactory.getLogger(DesafioController.class);

    // injeção de dependencia
    @Autowired
    DesafioRepository desafioRepository;

    // List<Desafio> desafios = new ArrayList<>();
    
    // Buscar por todos os desafios
    @GetMapping
    public List<Desafio> index() {
        return desafioRepository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Desafio> create(@RequestBody Desafio desafio) {
        log.info("Cadastrando um desafio" + desafio);

        desafioRepository.save(desafio);

        return ResponseEntity.status(HttpStatus.CREATED).body(desafio);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Desafio> show(@PathVariable Integer id) {

        log.info("buscando desafio por id" + id);
        var buscaDesafio = desafioRepository.findById(id);
        
        if(buscaDesafio.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(buscaDesafio.get());
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Desafio> update(@PathVariable Integer id, @RequestBody Desafio desafio) {

        log.info("Atualizando o desafio" + id);

        var buscaDesafioUpdate = desafioRepository.findById(id);

        if (buscaDesafioUpdate.isEmpty())
            return ResponseEntity.notFound().build();
           
            desafio.setId(id);
            desafioRepository.save(desafio);

            return ResponseEntity.ok(desafio);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Desafio> destroy(@PathVariable Integer id) {
        log.info("Deletando um desafio" + id);
        var buscaDesafioDelete = desafioRepository.findById(id);

        if(buscaDesafioDelete.isEmpty())
            return ResponseEntity.notFound().build();;

            desafioRepository.delete(buscaDesafioDelete.get());

            return ResponseEntity.noContent().build();
    }
}
