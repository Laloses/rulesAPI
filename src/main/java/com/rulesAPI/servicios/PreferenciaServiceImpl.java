package com.rulesAPI.servicios;

import com.rulesAPI.modelos.entidades.Preferencia;
import com.rulesAPI.repositorios.PreferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author EMHH 21-02-22
 * @extends Extiende del servicio generico implementado para tener acceso a lo basico del crud
 * @implements Implementa la interface de TarjetaService
 */
@Service
public class PreferenciaServiceImpl extends GenericServiceImpl<Preferencia, PreferenciaRepository> implements PreferenciaService {

    @Autowired
    public PreferenciaServiceImpl(PreferenciaRepository repository) {
        super(repository);
    }
    
}
