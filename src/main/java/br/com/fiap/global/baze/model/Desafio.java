package br.com.fiap.global.baze.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Desafio {
    
    private Integer id;

    private String desafio;

    private String descricao;

    private String tempo;

    private String recompensa;
    
}
