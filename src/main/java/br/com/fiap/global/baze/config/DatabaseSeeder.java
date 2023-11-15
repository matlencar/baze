package br.com.fiap.global.baze.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.global.baze.repository.BicicletaRepository;
import br.com.fiap.global.baze.repository.CorridaRepository;
import br.com.fiap.global.baze.repository.DesafioRepository;
import br.com.fiap.global.baze.repository.EnderecoRepository;
import br.com.fiap.global.baze.repository.RegistroRepository;
import br.com.fiap.global.baze.repository.TelefoneRepository;
import br.com.fiap.global.baze.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    BicicletaRepository bicicletaRepository;

    @Autowired
    CorridaRepository corridaRepository;

    @Autowired
    DesafioRepository desafioRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    RegistroRepository registroRepository;

    @Autowired
    TelefoneRepository telefoneRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public void run(String... args) throws Exception {

        
    }
}
