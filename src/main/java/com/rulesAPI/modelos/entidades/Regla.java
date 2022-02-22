package com.rulesAPI.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author laloses
 */
@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "reglas", schema = "rules")
public class Regla implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @NotNull
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String nombre;
    
    @NotNull
    @Column(name = "cantidad_hechos", nullable = false)
    private int cantidadHechos;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "conclusion_id", foreignKey = @ForeignKey(name = "FK_conclusion"))
    private Conclusion conclusion;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "regla_hecho", schema = "rules",
            joinColumns = @JoinColumn(name = "regla_id"),
            inverseJoinColumns = @JoinColumn(name = "hecho_id")
            )
    @JsonIgnoreProperties({"reglas"})
    private List<Hecho> hechos;

    public Regla(Long id, String nombre, int cantidadHechos) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHechos = cantidadHechos;
    }
    
}
