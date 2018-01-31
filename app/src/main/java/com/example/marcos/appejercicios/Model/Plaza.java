package com.example.marcos.appejercicios.Model;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class Plaza {
    //Atts
    private String Nombre;
    private Integer distancia;
    private String ubicacion;

    //Constructor
    public Plaza(String nombre) {
        Nombre = nombre;
    }

    //Getters
    public String getNombre() {
        return Nombre;
    }
}
