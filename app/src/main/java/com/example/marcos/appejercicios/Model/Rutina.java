package com.example.marcos.appejercicios.Model;

import java.util.List;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class Rutina extends Entrenamiento {
    //Atts
    private List<Integer> listaEjercicios;
    private Long tiempo;
    private Long mejorTiempo;
    private Integer logo;
    private String duracionEstimada;
    private Integer fotoTipo;
    private String tipo;
    private String zonaQueTrabaja;
    private String descripcion;


    //Constructores
    public Rutina(String nombre, Integer dificultad, Integer puntos, List<Integer> listaEjercicios, Integer logo, String duracionEstimada) {
        super(nombre, dificultad, puntos);
        this.listaEjercicios = listaEjercicios;
        this.logo =  logo;
        this.duracionEstimada = duracionEstimada;
    }

    public Rutina(String nombre, Integer dificultad, Integer puntos, List<Integer> listaEjercicios, Integer logo, String duracionEstimada, Integer fotoTipo, String tipo, String zonaQueTrabaja, String descipcion) {
        super(nombre, dificultad, puntos);
        this.listaEjercicios = listaEjercicios;
        this.fotoTipo = fotoTipo;
        this.tipo = tipo;
        this.zonaQueTrabaja = zonaQueTrabaja;
        this.logo = logo;
        this.duracionEstimada = duracionEstimada;
        this.descripcion = descipcion;
    }



    //Getters
    public List<Integer> getListaEjercicios() {
        return listaEjercicios;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public Long getMejorTiempo() {
        return mejorTiempo;
    }

    public Integer getLogo() {
        return logo;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }

    public Integer getFotoTipo() {
        return fotoTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getZonaQueTrabaja() {
        return zonaQueTrabaja;
    }
}
