package com.example.marcos.appejercicios.DAO;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 01-Feb-18.
 */

public class DaoEjEstiramiento {


    List<Ejercicio> ejercicioList = new ArrayList<>();

    //Buscar todos los Ejercicios
    public List<Ejercicio> buscarTodosEjsEsti() {
        ejercicioList.add(ejercicio5);
        ejercicioList.add(ejercicio6);
        ejercicioList.add(ejercicio5);
        ejercicioList.add(ejercicio6);
        ejercicioList.add(ejercicio5);
        return ejercicioList;
    }


    //Buscar EjercicioS por id
    public List<Ejercicio> buscarEjsEstiId(List<Integer> idList) {
        List<Ejercicio> listaEjercicioId = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarTodosEjsEsti();
        for (Integer id : idList) {
            for (Ejercicio ejercicio : listaglobal) {
                if (ejercicio.getId().equals(id)) {
                    listaEjercicioId.add(ejercicio);
                }
            }
        }

        return listaEjercicioId;
    }


    //Variables para videos
    String videoAbdominales = "android.resource://com.example.marcos.appejercicios/"+ R.raw.abdominales;
    String videoBurpees = "android.resource://com.example.marcos.appejercicios/"+ R.raw.burpees;
    String videoCaderas = "android.resource://com.example.marcos.appejercicios/"+ R.raw.caderas;
    String videoEliptica = "android.resource://com.example.marcos.appejercicios/"+ R.raw.eliptica;
    String videoPecho = "android.resource://com.example.marcos.appejercicios/"+ R.raw.pecho_1;
    String videoJumping = "android.resource://com.example.marcos.appejercicios/"+ R.raw.jumping_jacks;
    String videoRodillas = "android.resource://com.example.marcos.appejercicios/"+ R.raw.rodillas_arriba;
    String videoEstiramientoUno = "android.resource://com.example.marcos.appejercicios/"+ R.raw.estiramiento_1;
    String videoEstiramientoAb = "android.resource://com.example.marcos.appejercicios/"+ R.raw.estiramiento_abdominales;
    String videoPiernas = "android.resource://com.example.marcos.appejercicios/"+ R.raw.piernas;
    String videoRemo = "android.resource://com.example.marcos.appejercicios/"+ R.raw.remo;
    String videoSaltos = "android.resource://com.example.marcos.appejercicios/"+ R.raw.saltos_cortos;

    //Hardcore
    Ejercicio ejercicio1 = new Ejercicio(1,"Abdominales", R.drawable.niveluno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "15 Minutos", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio2 = new Ejercicio(2,"Burpees", R.drawable.nivelcuatro, 15, R.drawable.ejercicio_flexiones, videoBurpees, "15 Minutos", "Piernas", "musculacion", "Remo" );
    Ejercicio ejercicio3 = new Ejercicio(3,"Laterales", R.drawable.niveldos, 15, R.drawable.ejercicio_caderas, videoCaderas, "15 Minutos", "Piernas", "aerobico", "nu");
    Ejercicio ejercicio4 = new Ejercicio(4,"Eliptica", R.drawable.niveltres, 25, R.drawable.ejercicio_eliptica, videoEliptica, "15 Minutos", "Piernas", "musculacion", "Andador");
    Ejercicio ejercicio5 = new Ejercicio(5,"Estiramiento Brazos", R.drawable.nivelcinco, 15, R.drawable.estiramiento_brazos, videoEstiramientoUno, "15 Minutos", "Piernas", "aerobico", "Andador");
    Ejercicio ejercicio6 = new Ejercicio(6,"Estiramiento Abdominales", R.drawable.nivelcinco, 15, R.drawable.estiramiento_gluteos, videoEstiramientoAb, "15 Minutos", "Piernas", "funcional", "Andador");
    Ejercicio ejercicio7 = new Ejercicio(7,"Jumping Jacks", R.drawable.nivelcinco, 15, R.drawable.ejercicio_brazos_5, videoJumping, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio8 = new Ejercicio(8,"Pectorales", R.drawable.nivelcinco, 15, R.drawable.ejercicio_brazos_3, videoPecho, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio9 = new Ejercicio(9,"Isquiotibiales", R.drawable.nivelcinco, 15, R.drawable.ejercicio_piernas, videoPiernas, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio10 = new Ejercicio(10,"Remo", R.drawable.nivelcinco, 15, R.drawable.ejercicio_remo, videoRemo, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio11 = new Ejercicio(11,"Rodillas Arriba", R.drawable.nivelcinco, 15, R.drawable.ejercicio_flexiones, videoRodillas, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio12 = new Ejercicio(12,"Multi Salto", R.drawable.nivelcinco, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "15 Minutos", "Piernas", "funcional", "Remo");


}