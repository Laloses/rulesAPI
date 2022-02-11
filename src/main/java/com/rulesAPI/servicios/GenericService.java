package com.rulesAPI.servicios;

import java.util.Optional;

/**
 * @author Eduardo Martell Hernandez Hernandez
 */
public interface GenericService<E> {
    
    public Optional<E> buscarPorId(Integer id);
    public E guardar(E entidad);
    public Iterable<E> guardarTodos(Iterable<E> entidad);
    public Iterable<E> buscarTodos();
    public void eliminarPorId(Integer id);
}
