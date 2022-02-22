package com.rulesAPI.servicios;

import com.rulesAPI.excepciones.NotFoundException;
import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Regla;
import com.rulesAPI.repositorios.ReglaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laloses
 */
@Service
public class ReglaServiceImpl extends GenericServiceImpl<Regla, ReglaRepository> implements ReglaService {

    @Autowired
    public ReglaServiceImpl(ReglaRepository repository) {
        super(repository);
    }

    @Override
    public List<Conclusion> buscarTarjetaPorTodosParametros(String preferencia, BigDecimal salario, int edad) {
        List<Conclusion> conclusion = repository.buscarTarjetaPorTodosParametros(preferencia, salario, edad);
        
        if(!conclusion.isEmpty()) throw new NotFoundException("No hay tarjetas con ese perfil");
        
        return conclusion;
    }
    
}
