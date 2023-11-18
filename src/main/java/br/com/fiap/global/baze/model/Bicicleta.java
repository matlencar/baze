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
// @Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_BAZE_BIKE")
public class Bicicleta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bike")
    private Long id;

    @NotBlank
    @Column(name = "nr_aro")
    private String aro;

    @NotNull
    @Column(name = "nr_quadro")
    private int quadro;

    @NotBlank
    @Column(name = "nr_peso")
    private String peso;

    @NotBlank
    @Column(name = "nm_cor")
    private String cor;

    @NotBlank
    @Column(name = "nm_tipo")
    private String tipo;

    @NotNull
    @Column(name = "nr_marcha")
    private int marcha;

    @ManyToOne 
	@JoinColumn 
    private Usuario usuario;
}
