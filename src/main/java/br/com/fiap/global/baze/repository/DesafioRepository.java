package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Desafio;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    
}
