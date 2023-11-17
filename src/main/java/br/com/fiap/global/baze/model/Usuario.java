package br.com.fiap.global.baze.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;
    
    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @NotNull
    private int idade;

    @NotNull
    private Double peso;

    @NotNull
    private Double altura;

    @NotBlank
    private String rg;

    @NotBlank
    private String cpf;

    @NotBlank
    private String status;

    @NotBlank
    private String genero;

    // @OneToMany
    // private List<Bicicleta> bicicletas;
}
