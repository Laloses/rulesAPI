package com.rulesAPI.repositorios;

import com.rulesAPI.modelos.entidades.Hecho;
import org.springframework.data.repository.CrudRepository;

/**
 * @author laloses
 */
public interface HechoRepository extends CrudRepository<Hecho, Long>{
    
}
