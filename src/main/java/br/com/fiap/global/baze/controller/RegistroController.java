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
import br.com.fiap.global.baze.model.Registro;
import br.com.fiap.global.baze.repository.RegistroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {
    
    Logger log = LoggerFactory.getLogger(RegistroController.class);

    // injeção de dependencia
    @Autowired
    RegistroRepository repository;
    
    // Buscar por todas as bicicletas
    @GetMapping
    public List<Registro> index() {
        return repository.findAll();
    }

    // Cadastro
    @PostMapping
    public ResponseEntity<Registro> create(@RequestBody @Valid Registro registro) {
        log.info("Cadastrando um registro" + registro);

        repository.save(registro);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Registro> show(@PathVariable Long id) {

        log.info("buscando um registro por id" + id);

        return ResponseEntity.ok(getRegistro(id));
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Registro> update(@PathVariable Long id, @RequestBody @Valid Registro registro) {

        log.info("Atualizando as informaçoes do registro" + id);
           
            getRegistro(id);

            registro.setId(id);
            repository.save(registro);

            return ResponseEntity.ok(registro);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Registro> destroy(@PathVariable Long id) {
        log.info("Deletando um registro do sistema" + id);

            repository.delete(getRegistro(id));

            return ResponseEntity.noContent().build();
    }

    private Registro getRegistro(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("registro não encontrada"));
    }
}
