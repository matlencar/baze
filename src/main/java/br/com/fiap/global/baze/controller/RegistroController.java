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

import br.com.fiap.global.baze.model.Registro;
import br.com.fiap.global.baze.repository.RegistroRepository;

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
    public ResponseEntity<Registro> create(@RequestBody Registro registro) {
        log.info("Cadastrando um registro" + registro);

        repository.save(registro);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    // Busca por ID
    @GetMapping("{id}")
    public ResponseEntity<Registro> show(@PathVariable Integer id) {

        log.info("buscando um registro por id" + id);
        var buscarRegistro = repository.findById(id);
        
        if(buscarRegistro.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(buscarRegistro.get());
    }

    // Atualizar
    @PutMapping("{id}")
    public ResponseEntity<Registro> update(@PathVariable Integer id, @RequestBody Registro registro) {

        log.info("Atualizando as informaçoes do registro" + id);

        var buscarRegistroUpdate = repository.findById(id);

        if (buscarRegistroUpdate.isEmpty())
            return ResponseEntity.notFound().build();
           
            registro.setId(id);
            repository.save(registro);

            return ResponseEntity.ok(registro);
    }

    // Deletar
    @DeleteMapping("{id}")
    public ResponseEntity<Registro> destroy(@PathVariable Integer id) {
        log.info("Deletando um registro do sistema" + id);
        var buscarRegistroDelete = repository.findById(id);

        if(buscarRegistroDelete.isEmpty())
            return ResponseEntity.notFound().build();;

            repository.delete(buscarRegistroDelete.get());

            return ResponseEntity.noContent().build();
    }
}
