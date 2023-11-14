package br.com.fiap.global.baze.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Corrida {
    
    private Integer id;
    private Double km;
    private Double tempo;

}
