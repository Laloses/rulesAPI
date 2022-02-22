package com.rulesAPI.datos;

import com.rulesAPI.modelos.entidades.Conclusion;
import com.rulesAPI.modelos.entidades.Hecho;
import com.rulesAPI.modelos.entidades.Regla;


/**
 * @author Eduardo Martell Hernandez Hernandez
 */
public class DatosDummy {
    //Hechos
    public static Hecho hechoPreferenciaShopping(){ return new Hecho(null, "preferencia", "shoppIng");}
    public static Hecho hechoEdadMaxima23(){ return new Hecho(null, "edadMaxima", "23");}
    public static Hecho hechoEdadMinima18(){ return new Hecho(null, "edadMinima", "18");}
    public static Hecho hechoSalarioMaximo15000(){ return new Hecho(null, "salarioMaximo", "15000");}
    public static Hecho hechoSalarioMinimo7000(){ return new Hecho(null, "salarioMinimo", "7000");}
    //Conclusiones
    public static Conclusion conclusion01(){ return new Conclusion(null,"B+smart, Afinity Card");}
    
    //Regkas
    public static Regla regla01(){ return new Regla(null,"shopping1",3);}
}
