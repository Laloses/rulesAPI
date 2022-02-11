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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author laloses
 */
@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "hechos", schema = "rules")
public class Hecho implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @Column(nullable = false, unique = true)
    private String nombre;
    
    @Column(nullable = false)
    private String valor;
    
    @OneToMany(mappedBy = "hecho", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReglaHecho> reglasHecho;

    public Hecho(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    
}
