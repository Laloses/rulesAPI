package com.rulesAPI.repositorios;

import com.rulesAPI.datos.DatosDummy;
import com.rulesAPI.modelos.entidades.Preferencia;
import com.rulesAPI.modelos.entidades.Tarjeta;
import com.rulesAPI.repositorios.TarjetaRepository;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author Eduardo Martell Hernandez Hernandez
 */
@DataJpaTest
public class TarjetaRepositoryTest {
    @Autowired
    private TarjetaRepository tarjetaRepository;
    
    @Autowired
    private PreferenciaRepository preferenciaRepository;
    
    @BeforeEach
    void setUp(){
        Tarjeta tarjeta = DatosDummy.tarjeta01();
        Preferencia preferencia = DatosDummy.preferencia01();
        
        tarjeta.setPreferencias(Arrays.asList(preferencia));
        
        tarjetaRepository.save(tarjeta);
        preferenciaRepository.save(preferencia);
    }
    
    @AfterEach
    void tearDown(){
        tarjetaRepository.deleteAll();
    }
    
    @Test
    @DisplayName("TEST: buscarConTodosParametros de TarjetasRepository")
    @Disabled
    void buscarConTodosParametros(){
        //GWT
        //Given (Setup)
        String preferencia = "shopping";
        BigDecimal salario = BigDecimal.valueOf(8000);
        int edad = 20;
        //When
        List<Tarjeta> expectedTarjetas = (List<Tarjeta>) tarjetaRepository.buscarConTodosParametros(preferencia,salario,edad);
        //Then
        Assertions.assertThat(expectedTarjetas.size() == 1).isTrue();
    }
}
