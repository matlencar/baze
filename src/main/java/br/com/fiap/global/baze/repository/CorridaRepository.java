package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Corrida;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {
    
}
