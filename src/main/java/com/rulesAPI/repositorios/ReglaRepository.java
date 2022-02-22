package com.rulesAPI.repositorios;

import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Regla;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author laloses
 */
@Repository
public interface ReglaRepository extends CrudRepository<Regla, Long>{
    
    @Query(value = "select DISTINCT c.* from rules.reglas r \n" +
"            join rules.conclusiones c on r.conclusion_id = c.id \n" +
"            left join rules.regla_hecho rh on rh.regla_id = r.id\n" +
"            left join rules.hechos h1 on h1.id = rh.hecho_id and h1.nombre = 'preferencia' and UPPER(h1.valor) = UPPER('shoppinG') \n" +
"            left join rules.hechos h2 on h2.id = rh.hecho_id and h2.nombre = 'salarioMinimo' and CAST(h2.valor as float) >= 8000 \n" +
"            left join rules.hechos h3 on h3.id = rh.hecho_id and h3.nombre = 'salarioMaximo' and IF(h3.valor != 'infinito', CAST(h3.valor as float) < 8000, TRUE ) \n" +
"            left join rules.hechos h4 on h4.id = rh.hecho_id and h4.nombre = 'edadMinima' and CAST(h4.valor as int) >= 22\n" +
"            left join rules.hechos h5 on h5.id = rh.hecho_id and h5.nombre = 'edadMaxima' and CAST(h5.valor as int) < 22", nativeQuery = true)
    public List<Conclusion> buscarTarjetaPorTodosParametros(String preferencia, BigDecimal salario, int edad);
}
