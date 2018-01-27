package com.example.marcos.appejercicios.Model;

import android.widget.VideoView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class Ejercicio extends Entrenamiento implements Serializable{
    private static final long serialVersionUID = 1L;
    //Atts
    private Integer id;
    private Integer foto;
    private String video;
    private VideoView gif;
    private String repeticiones;
    private String zonaQueTrabaja;
    private String tipoEjercicio;
    private List<Rutina> rutinasDondeEncontrarlo;
    private String aparato;



    public Ejercicio(String nombre, Integer dificultad, Integer puntos, Integer foto, String video, VideoView gif, String repeticiones, String zonaQueTrabaja, String tipoEjercicio, List<Rutina> rutinasDondeEncontrarlo, String aparato) {
        super(nombre, dificultad, puntos);
        this.foto = foto;
        this.video = video;
        this.gif = gif;
        this.repeticiones = repeticiones;
        this.zonaQueTrabaja = zonaQueTrabaja;
        this.tipoEjercicio = tipoEjercicio;
        this.rutinasDondeEncontrarlo = rutinasDondeEncontrarlo;
        this.aparato = aparato;
    }

    public Ejercicio(Integer id, String nombre, Integer dificultad, Integer puntos, Integer foto, String video, String repeticiones, String zonaQueTrabaja, String tipoEjercicio, String aparato) {
        super(nombre, dificultad, puntos);
        this.id = id;
        this.foto = foto;
        this.video = video;
        this.repeticiones = repeticiones;
        this.zonaQueTrabaja = zonaQueTrabaja;
        this.tipoEjercicio = tipoEjercicio;
        this.aparato = aparato;
    }

    //Getters
    public Integer getFoto() {
        return foto;
    }

    public String getVideo() {
        return video;
    }

    public VideoView getGif() {
        return gif;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public String getZonaQueTrabaja() {
        return zonaQueTrabaja;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public List<Rutina> getRutinasDondeEncontrarlo() {
        return rutinasDondeEncontrarlo;
    }

    public String getAparato() {
        return aparato;
    }

    public Integer getId() {
        return id;
    }
}
