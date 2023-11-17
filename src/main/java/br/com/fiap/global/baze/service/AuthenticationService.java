package br.com.fiap.global.baze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.global.baze.model.Usuario;
import br.com.fiap.global.baze.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService{

    @Autowired
    UsuarioRepository repository;

    @Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
        Usuario usuario = repository.findByLogin(login)
             .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + login));
             return usuario;
	}
    
}
