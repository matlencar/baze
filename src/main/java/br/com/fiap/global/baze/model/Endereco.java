package br.com.fiap.global.baze.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "T_BAZE_ENDERECO")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nm_logradouro")
    private String logradouro;

    @NotNull
    @Column(name = "nr_logradouro")
    private int numero;

    @NotBlank
    @Column(name = "nm_bairro")
    private String bairro;

    @NotBlank
    @Column(name = "nm_cidade")
    private String cidade;
    
    @NotBlank
    @Column(name = "nm_pais")
    private String pais;

    @NotBlank
    @Column(name = "nr_cep")
    private String cep;

    @NotBlank
    @Column(name = "ds_complemento")
    private String complemento;

    @ManyToOne 
	@JoinColumn 
    private Usuario usuario;
}
