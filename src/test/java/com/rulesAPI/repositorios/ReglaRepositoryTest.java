package com.rulesAPI.repositorios;

import com.rulesAPI.datos.DatosDummy;
import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Hecho;
import com.rulesAPI.modelos.entidades.Regla;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author Eduardo Martell Hernandez Hernandez
 */
@DataJpaTest
public class ReglaRepositoryTest {
    @Autowired
    private HechoRepository hechoRepository;
    @Autowired
    private ConclusionRepository conclusionRepository;
    @Autowired
    private ReglaRepository reglaRepository;
    
    @BeforeEach
    void setUp(){
        List<Hecho> hechos = Arrays.asList(
            DatosDummy.hechoPreferenciaShopping(),
            DatosDummy.hechoEdadMaxima23(),
            DatosDummy.hechoEdadMinima18(),
            DatosDummy.hechoSalarioMaximo15000(),
            DatosDummy.hechoSalarioMinimo7000()
        );
        
        Regla regla = DatosDummy.regla01();
        
        Conclusion conclusion = DatosDummy.conclusion01();
        
        regla.setHechos(hechos);
        regla.setConclusion(conclusion);
                
        conclusionRepository.save(conclusion);
        hechoRepository.saveAll(hechos);
        reglaRepository.save(regla);
    }
    
    @AfterEach
    void tearDown(){
        hechoRepository.deleteAll();
        conclusionRepository.deleteAll();
        reglaRepository.deleteAll();
    }
    
    @Test
    @DisplayName("TEST: buscarTarjetaPorTodosParametros de ReglaRepository")
    void buscarTarjetaPorTodosParametros(){
        //GWT
        //Given (Setup)
        String givenNombre = "shoppinG";
        BigDecimal salario = BigDecimal.valueOf(8000.00);
        int edad = 22;
        //When
        List<Conclusion> expectedConclusion = reglaRepository.buscarTarjetaPorTodosParametros(givenNombre, salario, edad);
        //Then
        Assertions.assertThat(expectedConclusion.size() == 1).isTrue();
    }
}
