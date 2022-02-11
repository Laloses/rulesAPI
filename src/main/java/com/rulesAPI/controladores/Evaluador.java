package com.rulesAPI.controladores;

import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Hecho;
import com.rulesAPI.servicios.ConclusionService;
import com.rulesAPI.servicios.ReglaService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author laloses
 */
@Getter
@Setter
public class Evaluador{
    @Autowired
    private ReglaService reglaService;
    
    @Autowired
    private HechoService hechoService;
    
    @Autowired
    private ConclusionService conclusionService;
    
    private HashMap<Hecho,String> entradas;
    
    public Set<Conclusion> evaluar(){
        //TODO: Buscar en las reglas si hay alguna que tenga la misma que entradas.size();
        //En caso afirmativo comparar los hechos de esa regla con los de las entradas y si lo comple devolver las conclusiones de esa regla
        return new HashSet<>();
    }

    public Evaluador(HashMap<Hecho, String> entradas) {
        this.entradas = entradas;
    }
    
    
}
