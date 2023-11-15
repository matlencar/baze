package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Bicicleta;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
    
}
