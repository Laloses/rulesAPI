package com.rulesAPI.servicios;

import com.rulesAPI.excepciones.NotFoundException;
import com.rulesAPI.modelos.entidades.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rulesAPI.repositorios.TarjetaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author EMHH 21-02-22
 * @extends Extiende del servicio generico implementado para tener acceso a lo basico del crud
 * @implements Implementa la interface de TarjetaService
 */
@Service
public class TarjetaServiceImpl extends GenericServiceImpl<Tarjeta, TarjetaRepository> implements TarjetaService {

    @Autowired
    public TarjetaServiceImpl(TarjetaRepository repository) {
        super(repository);
    }

    /**
     * Metodo principal del api para buscar coincidencias en la base de datos
     * @param preferencia
     * @param salario
     * @param edad
     * @return Una lista de tarjetas que coincidan con los parametros
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> buscarConTodosParametros(String preferencia, BigDecimal salario, int edad) {
        List<Tarjeta> tarjetas = (List<Tarjeta>) repository.buscarConTodosParametros(preferencia, salario, edad);
        
        if(tarjetas.isEmpty()) throw new NotFoundException("No hay tarjetas concidentes");
        
        return tarjetas;
    }
    
    @Override
    @Transactional
    public Tarjeta actualizar(Long tarjetaId, Tarjeta tarjeta) {
        Optional<Tarjeta> oTarjeta = repository.findById(tarjetaId);

        if(!oTarjeta.isPresent())
                throw new NotFoundException(String.format("El aula con ID %d no existe", tarjetaId));

        Tarjeta aulaActualizada = null;
        oTarjeta.get().setPreferencias(tarjeta.getPreferencias());
        oTarjeta.get().setEdadMaxima(tarjeta.getEdadMaxima());
        oTarjeta.get().setEdadMinima(tarjeta.getEdadMinima());
        oTarjeta.get().setSalarioMaximo(tarjeta.getSalarioMaximo());
        oTarjeta.get().setSalarioMinimo(tarjeta.getSalarioMinimo());
        aulaActualizada = repository.save(oTarjeta.get());

        return aulaActualizada;
    }
    
}
