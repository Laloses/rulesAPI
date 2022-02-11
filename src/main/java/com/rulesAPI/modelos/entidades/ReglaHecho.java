package com.rulesAPI.modelos.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author laloses
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "regla_hecho", schema = "rules")
public class ReglaHecho {
    @Column(nullable = false)
    private String valor;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "regla_id")
    private Regla regla;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hecho_id")
    private Hecho hecho;
}
