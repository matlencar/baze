package br.com.fiap.global.baze.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bicicleta {
    
    private Integer id;

    private String aro;

    private int quadro;

    private String peso;

    private String cor;

    private String tipo;

    private int marcha;
}
