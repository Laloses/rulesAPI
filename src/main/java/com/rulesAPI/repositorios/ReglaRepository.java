package com.rulesAPI.repositorios;

import com.rulesAPI.modelos.entidades.Regla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laloses
 */
@Repository
public interface ReglaRepository extends CrudRepository<Regla, Integer>{
    
}
