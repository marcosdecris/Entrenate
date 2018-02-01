package com.example.marcos.appejercicios.Model;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

/**
 * Created by main on 1/31/18.
 */

public class PadreExpandable implements ParentObject{

    //Atributos
    private String titulo;
    private List<Object> listaHijos;
    private List<Ejercicio> listaEjercicio;

    //Constructor


    public PadreExpandable(String titulo) {
        this.titulo = titulo;
    }

    //Getters y Setters

    @Override
    public List<Object> getChildObjectList() {
        return listaHijos;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
    listaHijos = list;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setChildObjectListEjercicio(List<Ejercicio> listaDeEjerciciosRutina) {
        listaEjercicio = listaDeEjerciciosRutina;
    }

    public List<Ejercicio> getchildObjectEjercicio(){
        return listaEjercicio;
    }
}
