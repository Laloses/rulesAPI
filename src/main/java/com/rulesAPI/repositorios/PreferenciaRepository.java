package com.rulesAPI.repositorios;

import com.rulesAPI.modelos.entidades.Preferencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laloses
 */
@Repository
public interface PreferenciaRepository extends CrudRepository<Preferencia, Long>{
}
