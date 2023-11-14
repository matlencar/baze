package br.com.fiap.global.baze.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    

    private Integer id;


    private String nome;


    private String email;


    private String senha;


    private int idade;


    private Double peso;


    private Double altura;


    private String rg;


    private String cpf;


    private String status;


    private String genero;
}
