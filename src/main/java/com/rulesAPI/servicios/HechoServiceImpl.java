package com.rulesAPI.servicios;

import com.rulesAPI.modelos.entidades.Hecho;
import com.rulesAPI.repositorios.HechoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laloses
 */
@Service
public class HechoServiceImpl extends GenericServiceImpl<Hecho, HechoRepository>implements HechoService {

    @Autowired
    public HechoServiceImpl(HechoRepository repository) {
        super(repository);
    }
    
}
