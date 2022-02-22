package com.rulesAPI.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author laloses
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "preferencias", schema = "tarjetas")
public class Preferencia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @NotNull
    @NotEmpty
    @Length(max=50, message = "Maximo 50 caracteres")
    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;
    
    @ManyToMany(mappedBy = "preferencias", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"tarjeta"})
    private List<Tarjeta> tarjetas;

    public Preferencia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    
}
