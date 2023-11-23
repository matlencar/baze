package br.com.fiap.global.baze.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.global.baze.model.Bicicleta;
import br.com.fiap.global.baze.model.Corrida;
import br.com.fiap.global.baze.model.Desafio;
import br.com.fiap.global.baze.model.Endereco;
import br.com.fiap.global.baze.model.Registro;
import br.com.fiap.global.baze.model.Telefone;
import br.com.fiap.global.baze.model.Usuario;
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

                Usuario usuario1 = new Usuario(1L, "matheus", "malencar292@gmail.com", "matlencar", "ola@", 29, 45.0, 1.75,
                                "01923466", "9900776655","Masculino");
                Usuario usuario2 = new Usuario(2L, "caio", "caio192@gmail.com", "caiou", "ola@", 22, 45.0, 1.85,
                                "01923466", "9900776655" ,"Masculino");
                Usuario usuario3 = new Usuario(3L, "Karen", "karen292@gmail.com", "Karem","ola@", 18, 55.0, 1.65,
                                "01923466",
                                "9900776655", "Feminino");
                usuarioRepository.saveAll(List.of(usuario1, usuario2, usuario3));

                Bicicleta bike1 = new Bicicleta(1L, "14", 18, "26", "Azul", "Speed", 6, usuario1);
                Bicicleta bike2 = new Bicicleta(2L, "14", 18, "20", "Roxa", "Dobravel", 6, usuario2);
                Bicicleta bike3 = new Bicicleta(3L, "14", 18, "28", "Verde", "Mountain", 6, usuario3);
                bicicletaRepository.saveAll(List.of(bike1, bike2, bike3));

                Corrida corrida1 = new Corrida(1L, 12.3, 14.0, usuario1);
                Corrida corrida2 = new Corrida(2L, 11.3, 15.0, usuario2);
                Corrida corrida3 = new Corrida(3L, 17.3, 19.0, usuario3);
                corridaRepository.saveAll(List.of(corrida1, corrida2, corrida3));

                Desafio desafio1 = new Desafio(1L, "Pedalar 2km", "Pedalar 2km durante 3 dias", "12:00 minutos",
                                "Gift card Decathlon 10% desconto");
                Desafio desafio2 = new Desafio(2L, "Pedalar 4km", "Pedalar 2km durante 5 dias", "10:00 minutos",
                                "Gift card Decathlon 20% desconto");
                Desafio desafio3 = new Desafio(3L, "Pedalar 8km", "Pedalar 8km durante 6 dias", "18:00 minutos",
                                "Gift card Decathlon 50% desconto");
                desafioRepository.saveAll(List.of(desafio1, desafio2, desafio3));

                Endereco endereco1 = new Endereco(1L, "Rua castro alves", 120, "Aclimaçao", "São Paulo", "Brasil",
                                "06187310", "N/A", usuario1);
                Endereco endereco2 = new Endereco(2L, "Rua americo", 1320, "Bras", "São Paulo", "Brasil",
                                "02183300", "N/A", usuario3);
                Endereco endereco3 = new Endereco(3L, "Rua da consolação", 1000, "Consolação", "São Paulo", "Brasil",
                                "03157110", "N/A", usuario2);
                enderecoRepository.saveAll(List.of(endereco1, endereco2, endereco3));

                Registro registro1 = new Registro(1L, "12h25", usuario1, desafio1);
                Registro registro2 = new Registro(2L, "16h45", usuario2, desafio2);
                Registro registro3 = new Registro(3L, "12h10", usuario3, desafio3);
                registroRepository.saveAll(List.of(registro1, registro2, registro3));

                Telefone telefone1 = new Telefone(1L, "987654431", 11, 55, usuario1);
                Telefone telefone2 = new Telefone(2L, "987754431", 11, 55, usuario2);
                Telefone telefone3 = new Telefone(3L, "988656451", 11, 55, usuario3);
                telefoneRepository.saveAll(List.of(telefone1, telefone2, telefone3));

        }

}
