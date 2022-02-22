package com.rulesAPI.servicios;

import java.util.Optional;

/**
 * @author Eduardo Martell Hernandez Hernandez
 */
public interface GenericService<E> {
    
    public Optional<E> buscarPorId(Long id);
    public E guardar(E entidad);
    public Iterable<E> guardarTodos(Iterable<E> entidad);
    public Iterable<E> buscarTodos();
    public void eliminarPorId(Long id);
}
