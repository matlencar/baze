package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.fiap.global.baze.model.Desafio;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    
    Page<Desafio> findByDescricaoContaining(String descricao, Pageable pageable);
}
