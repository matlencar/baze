package br.com.fiap.global.baze.service;

import java.time.temporal.ChronoUnit;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.global.baze.model.Credencial;
import br.com.fiap.global.baze.model.Token;
import br.com.fiap.global.baze.model.Usuario;
import br.com.fiap.global.baze.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;

import jakarta.validation.Valid;

@Service
public class TokenService {

    @Autowired
    UsuarioRepository repository;

    @Value("${jwt.secret}")
    String secret;

    public Token generateToken(@Valid Credencial credencial) {

        Algorithm alg = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withSubject(credencial.login())
                .withIssuer("baze")
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .sign(alg);

        return new Token(token, "JWT", "Bearer");
    }

    public Usuario getValidateUser(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var login = JWT.require(alg)
                .withIssuer("baze")
                .build()
                .verify(token)
                .getSubject();

        return repository.findByLogin(login)
                .orElseThrow(() -> new JWTVerificationException("Usuario invalido"));
    }
}
