package com.rulesAPI.servicios;

import com.rulesAPI.modelos.entidades.Tarjeta;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author EMHH 21-02-22
 * @extends Extiende del servicio generico para tener acceso a lo basico del crud
 */
public interface TarjetaService extends GenericService<Tarjeta>{
    public List<Tarjeta> buscarConTodosParametros(String preferencia, BigDecimal salario, int edad);
    public Tarjeta actualizar(Long tarjetaId, Tarjeta tarjeta);
}
