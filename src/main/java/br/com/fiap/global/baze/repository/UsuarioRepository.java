package br.com.fiap.global.baze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.global.baze.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
