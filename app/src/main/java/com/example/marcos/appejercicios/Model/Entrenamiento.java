package com.example.marcos.appejercicios.Model;

import android.widget.ImageView;

/**
 * Created by Marcos on 23-Jan-18.
 */

public abstract class Entrenamiento {
    //Atts
    private String nombre;
    private Integer dificultad;
    private Integer puntos;

    //Constructores
    public Entrenamiento(String nombre, Integer dificultad, Integer puntos) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.puntos = puntos;
    }

    public Entrenamiento(String nombre, Integer dificultad) {
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public Integer getDificultad() {
        return dificultad;
    }

    public Integer getPuntos() {
        return puntos;
    }


}
