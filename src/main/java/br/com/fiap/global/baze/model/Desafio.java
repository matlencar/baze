package br.com.fiap.global.baze.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Table(name = "T_BAZE_DESAFIO")
public class Desafio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1)
    @Column(name = "nm_desafio")
    private String nome;

    @NotBlank
    @Size(min = 1, max = 255)
    @Column(name = "ds_desafio")
    private String descricao;

    @NotBlank
    @Column(name = "tm_tempo")
    private String tempo;

    @NotBlank
    @Column(name = "ds_recompensa")
    private String recompensa;
    

}
