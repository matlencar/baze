package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
