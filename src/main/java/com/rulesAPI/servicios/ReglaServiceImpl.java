/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rulesAPI.servicios;

import com.rulesAPI.modelos.entidades.Regla;
import com.rulesAPI.repositorios.ReglaRepository;
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
    
}
