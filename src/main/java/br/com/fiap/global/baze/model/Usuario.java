package br.com.fiap.global.baze.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "T_BAZE_USUARIO")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nm_usuario")
    private String nome;

    @NotBlank
    @Column(name = "nm_email")
    private String email;
    
    @NotBlank
    @Column(name = "nm_login")
    private String login;

    @NotBlank
    @Column(name = "nm_senha")
    private String senha;

    @NotNull
    @Column(name = "nr_idade")
    private int idade;


    @NotBlank
    @Column(name = "nr_rg")
    private String rg;

    @NotBlank
    @Column(name = "nr_cpf")
    private String cpf;

    

    @NotBlank
    @Column(name = "tp_genero")
    private String genero;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getPassword() {
        
        return senha;
    }

    @Override
    public String getUsername() {
       
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    // @JsonIgnoreProperties(value = "usuario", allowSetters=true)
    // private List<Bicicleta> bicicletas;
}
