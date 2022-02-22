package com.rulesAPI.servicios;

import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Regla;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author laloses
 */
public interface ReglaService extends GenericService<Regla>{
    public List<Conclusion> buscarTarjetaPorTodosParametros(String preferencia, BigDecimal salario, int edad);
}
