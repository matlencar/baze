package br.com.fiap.global.baze.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    
    private Integer id;

    private String logradouro;

    private int numero;

    private String bairro;

    private String cidade;
    
    private String pais;

    private String cep;

    private String complemento;
}
