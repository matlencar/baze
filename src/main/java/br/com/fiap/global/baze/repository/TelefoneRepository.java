package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
    
}
