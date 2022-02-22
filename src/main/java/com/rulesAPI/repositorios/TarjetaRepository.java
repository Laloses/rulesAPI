package com.rulesAPI.repositorios;

import com.rulesAPI.modelos.entidades.Tarjeta;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author EMHH 21-02-22
 */
@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Long>{
    
    @Query("select t from Tarjeta t join fetch t.preferencias p "
            + "where UPPER(p.nombre) = UPPER(?1) "
            + "and t.salarioMinimo <= (?2) "
            + "and t.salarioMaximo > (?2) "
            + "and t.edadMinima <= (?3) "
            + "and t.edadMaxima > (?3) ")
    public Iterable<Tarjeta> buscarConTodosParametros(String preferencia, BigDecimal salario, int edad);
}
