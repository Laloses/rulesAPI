package com.rulesAPI.servicios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eduardo Martell Hernandez Hernandez
 * @param <E> Entidad que se hara consulta
 * @param <R> Repository de esa entidad
 */
public class GenericServiceImpl<E, R extends CrudRepository<E,Integer>> implements GenericService<E>{

    protected final R repository;

    public GenericServiceImpl(R repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<E> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E guardar(E entidad) {
        return repository.save(entidad);
    }
    
    @Override
    @Transactional
    public Iterable<E> guardarTodos(Iterable<E> entidad) {
        return repository.saveAll(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> buscarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void eliminarPorId(Integer id) {
        repository.deleteById(id);
    }
    
}
