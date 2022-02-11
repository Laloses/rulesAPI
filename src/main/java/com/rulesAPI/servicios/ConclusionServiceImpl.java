package com.rulesAPI.servicios;

import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.repositorios.ConclusionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author laloses
 */
@Service
public class ConclusionServiceImpl extends GenericServiceImpl<Conclusion, ConclusionRepository>implements ConclusionService {

    @Autowired
    public ConclusionServiceImpl(ConclusionRepository repository) {
        super(repository);
    }
   
}
