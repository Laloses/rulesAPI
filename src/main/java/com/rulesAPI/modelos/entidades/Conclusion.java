package com.rulesAPI.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
@Table(name = "conclusiones", schema = "rules")
public class Conclusion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @NotNull
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String valor;
    
    @OneToMany(mappedBy = "conclusion", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"conclusion"})
    private Set<Regla> reglas;

    public Conclusion(Long id, String valor) {
        this.id = id;
        this.valor = valor;
    }
    
}
