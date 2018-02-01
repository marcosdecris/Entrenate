package com.example.marcos.appejercicios.Model;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class Plaza {
    //Atts
    private String Nombre;
    private Integer distancia;
    private String direccion;

    //Constructor
    public Plaza(String nombre, String direccion) {
        this.Nombre = nombre;
        this.direccion = direccion;
    }

    //Getters
    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
