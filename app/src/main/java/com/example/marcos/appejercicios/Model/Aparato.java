package com.example.marcos.appejercicios.Model;

import java.util.List;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class Aparato  {
    //Atts
    private Integer foto;
    private List<Integer> listaEjercicios;
    private String zonaQueTrabaja;
    private String nombre;


    //Constructor
    public Aparato(String nombre, Integer foto, String zonaQueTrabaja) {
        this.nombre = nombre;
        this.foto = foto;
        this.zonaQueTrabaja = zonaQueTrabaja;
    }

    //Constructor
    public Aparato(String nombre, Integer foto, String zonaQueTrabaja, List<Integer> listaEjercicios) {
        this.nombre = nombre;
        this.foto = foto;
        this.zonaQueTrabaja = zonaQueTrabaja;
        this.listaEjercicios = listaEjercicios;
    }


    //Getters
    public Integer getFoto() {
        return foto;
    }

    public List<Integer> getListaEjercicios() {
        return listaEjercicios;
    }

    public String getZonaQueTrabaja() {
        return zonaQueTrabaja;
    }

    public String getNombre() {
        return nombre;
    }

}
