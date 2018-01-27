package com.example.marcos.appejercicios.Model;

import android.widget.ImageView;

import java.util.List;


public class Usuario {
    //Atts
    private String nombre;
    private String apellido;
    private ImageView foto;
    private Integer puntosAcumulados;
    private List<Entrenamiento> listaEntrenamientos;

    //Constructor
    public Usuario(String nombre, String apellido, ImageView foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ImageView getFoto() {
        return foto;
    }

    public Integer getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public List<Entrenamiento> getListaEntrenamientos() {
        return listaEntrenamientos;
    }
}
