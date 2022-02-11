package com.rulesAPI.modelos.entidades;

import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    protected int id;
    
    @Column(nullable = false, unique = true)
    private String nombre;
    
    @Column(name = "cantidad_hechos", nullable = false)
    private int cantidadHechos;
    
    @OneToMany(mappedBy = "regla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ReglaHecho> reglasHechos;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "regla_conclusion", schema = "rules",
            joinColumns = @JoinColumn(name = "regla_id"),
            inverseJoinColumns = @JoinColumn(name = "conclusion_id")
            )
    private Set<Conclusion> conclusiones;

    public Regla(String nombre, int cantidadHechos, Set<Conclusion> conclusiones) {
        this.nombre = nombre;
        this.cantidadHechos = cantidadHechos;
        this.conclusiones = conclusiones;
    }
    
}
