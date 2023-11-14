package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    
}
