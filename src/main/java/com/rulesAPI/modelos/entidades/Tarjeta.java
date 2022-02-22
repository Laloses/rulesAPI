package com.rulesAPI.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author EMHH 21-02-22
 */
@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "tarjetas", schema = "tarjetas")
public class Tarjeta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String nombre;
    
    @NotNull
    @Min(value = 7000, message = "Minimo mil")
    @Column(name = "salario_minimo", nullable = false, length = 11)
    private BigDecimal salarioMinimo;
    
    @NotNull
    @Min(value = 7000, message = "Minimo mil")
    @Column(name = "salario_maximo", nullable = false, length = 20)
    private BigDecimal salarioMaximo;
    
    @NotNull
    @Min(value = 18, message = "Minimo 18")
    @Max(value = 100, message = "Maximo 100")
    @Column(name = "edad_minima", nullable = false, length = 3)
    private int edadMinima;
    
    @NotNull
    @Min(value = 18, message = "Minimo 18")
    @Max(value = 100, message = "Maximo 100")
    @Column(name = "edad_maxima", nullable = false, length = 3)
    private int edadMaxima;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tarjeta_preferencia", schema = "tarjetas",
            joinColumns = @JoinColumn(name = "tarjeta_id"),
            inverseJoinColumns = @JoinColumn(name = "preferencia_id")
            )
    @JsonIgnoreProperties({"tarjetas"})
    private List<Preferencia> preferencias;

    public Tarjeta(Long id, String nombre, BigDecimal salarioMinimo, BigDecimal salarioMaximo, int edadMinima, int edadMaxima) {
        this.id = id;
        this.nombre = nombre;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
    }
    
    
    
}
