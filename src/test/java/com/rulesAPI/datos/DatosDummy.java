package com.rulesAPI.datos;

import com.rulesAPI.modelos.entidades.Preferencia;
import com.rulesAPI.modelos.entidades.Tarjeta;
import java.math.BigDecimal;

/**
 * @author Eduardo Martell Hernandez Hernandez
 */
public class DatosDummy {
    //Tarjetas
    public static Tarjeta tarjeta01(){ return new Tarjeta(null, "Afinity Card", BigDecimal.valueOf(7000), BigDecimal.valueOf(11599), 18, 23);}
    //Preferencias
    public static Preferencia preferencia01(){ return new Preferencia(null, "shopping");}
}
