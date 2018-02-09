package com.example.marcos.appejercicios.DAO;

import android.net.Uri;

import com.example.marcos.appejercicios.Model.Aparato;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 24-Jan-18.
 */

public class DaoEjercicio {
    List<Ejercicio> ejercicioList = new ArrayList<>();

    // TODO -- Borrar cuando se use Json


    //Buscar Ejercicios por Aparato
    public List<Ejercicio> listaEjsAparato(Aparato aparato){

        return ejercicioList;
    }

    //Buscar todos los Ejercicios
    public List<Ejercicio> buscarEjercicios( ){
        ejercicioList.add(ejercicio1);
        ejercicioList.add(ejercicio2);
        ejercicioList.add(ejercicio3);
        ejercicioList.add(ejercicio4);
        ejercicioList.add(ejercicio5);
        ejercicioList.add(ejercicio6);
        ejercicioList.add(ejercicio7);
        ejercicioList.add(ejercicio8);
        ejercicioList.add(ejercicio9);
        ejercicioList.add(ejercicio10);
        ejercicioList.add(ejercicio11);
        ejercicioList.add(ejercicio12);
        ejercicioList.add(ejercicio13);
        ejercicioList.add(ejercicio14);
        ejercicioList.add(ejercicio15);
        ejercicioList.add(ejercicio16);
        ejercicioList.add(ejercicio17);
        ejercicioList.add(ejercicio18);
        ejercicioList.add(ejercicio19);
        ejercicioList.add(ejercicio20);
        ejercicioList.add(ejercicio21);
        ejercicioList.add(ejercicio22);
        return ejercicioList;
    }



    //Buscar Ejercicio por tipo (Musculacion, aerobicos)
    public List<Ejercicio> buscarEjsTipo(String tipoEj){
        List<Ejercicio> listaEjTipo = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Ejercicio ejercicio: listaglobal){
            if(ejercicio.getTipoEjercicio().equals(tipoEj)){
                listaEjTipo.add(ejercicio);
            }
        }
        return listaEjTipo;
    }

    //Buscar Ejercicio por aparato
    public List<Ejercicio> buscarEjAparato(String aparato){
        List<Ejercicio> listaEjercicioAparato = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Ejercicio ejercicio: listaglobal){
            if(ejercicio.getAparato().equals(aparato)){
                listaEjercicioAparato.add(ejercicio);
            }
        }
        return listaEjercicioAparato;
    }

    //Buscar EjercicioS por id
    public List<Ejercicio> buscarEjsPorId(List<Integer> idList){
        List<Ejercicio> listaEjercicioId = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Integer id: idList){
            for(Ejercicio ejercicio: listaglobal){
                if(ejercicio.getId().equals(id)){
                    listaEjercicioId.add(ejercicio);
                }
            }
        }

        return listaEjercicioId;
    }

    //Buscar Ejercicio por id
    public Ejercicio buscarEjPorId(Integer id){
        Ejercicio ejercicioBuscado = null;
        List<Ejercicio> listaglobal = buscarEjercicios();
        for(Ejercicio ejercicio: listaglobal){
            if(ejercicio.getId().equals(id)){
                ejercicioBuscado = ejercicio;
                break;
            }
        }
        return ejercicioBuscado;
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
    Ejercicio ejercicio1 = new Ejercicio(1,"Abdominales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "aerobico", "Andador");
    Ejercicio ejercicio2 = new Ejercicio(2,"Burpees", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_flexiones, videoBurpees, "x12", "Piernas", "musculacion", "Remo" );
    Ejercicio ejercicio3 = new Ejercicio(3,"Laterales", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_caderas, videoCaderas, "x12", "Caderas", "aerobico", "nu");
    Ejercicio ejercicio4 = new Ejercicio(4,"Eliptica", R.drawable.dificultad_tres, 25, R.drawable.ejercicio_eliptica, videoEliptica, "x12", "Piernas", "aerobico", "Andador");
    Ejercicio ejercicio5 = new Ejercicio(5,"Estiramiento Brazos", R.drawable.dificultad_tres, 15, R.drawable.estiramiento_brazos, videoEstiramientoUno, "x12", "Torso", "aerobico", "Andador");
    Ejercicio ejercicio6 = new Ejercicio(6,"Oblicuos", R.drawable.dificultad_tres, 15, R.drawable.estiramiento_gluteos, videoEstiramientoAb, "x12", "Piernas", "funcional", "Andador");
    Ejercicio ejercicio7 = new Ejercicio(7,"Jumping Jacks", R.drawable.dificultad_dos, 15, R.drawable.ejercicios_jumping_jacks, videoJumping, "x12", "Torso", "funcional", "Remo");
    Ejercicio ejercicio8 = new Ejercicio(8,"Pectorales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_brazos_3, videoPecho, "x12", "Pectorales", "funcional", "Remo");
    Ejercicio ejercicio9 = new Ejercicio(9,"Isquiotibiales", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio10 = new Ejercicio(10,"Remo", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Espalda", "funcional", "Remo");
    Ejercicio ejercicio11 = new Ejercicio(11,"Rodillas Arriba", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_rodillas_arriba, videoRodillas, "x12", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio12 = new Ejercicio(12,"Multi Salto", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio13 = new Ejercicio(13,"Remo", R.drawable.dificultad_dos, 15, R.drawable.ejercicio_remo, videoRemo, "x12", "Espalda", "musculacion", "Remo");
    Ejercicio ejercicio14 = new Ejercicio(14,"Rodillas Arriba", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_rodillas_arriba, videoRodillas, "x12", "Piernas", "aerobico", "Remo");
    Ejercicio ejercicio15= new Ejercicio(15,"Multi Salto", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Piernas", "aerobico", "Remo");
    Ejercicio ejercicio16 = new Ejercicio(16,"Burpees", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_flexiones, videoBurpees, "x12", "Piernas", "aerobico", "Remo" );
    Ejercicio ejercicio17 = new Ejercicio(17,"Isquiotibiales", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_piernas, videoPiernas, "x12", "Piernas", "musculacion", "Remo");
    Ejercicio ejercicio18 = new Ejercicio(18,"Abdominales", R.drawable.dificultad_uno, 15, R.drawable.ejercicio_abdominales, videoAbdominales, "x12", "Abdominales", "musculacion", "Andador");
    Ejercicio ejercicio19 = new Ejercicio(19,"Multi Salto", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_pasadas_2, videoSaltos, "x12", "Piernas", "musculacion", "Remo");
    Ejercicio ejercicio20 = new Ejercicio(20,"Oblicuos", R.drawable.dificultad_tres, 15, R.drawable.estiramiento_gluteos, videoEstiramientoAb, "x12", "Piernas", "musculacion", "Andador");
    Ejercicio ejercicio21 = new Ejercicio(21,"Jumping Jacks", R.drawable.dificultad_dos, 15, R.drawable.ejercicios_jumping_jacks, videoJumping, "x12", "Torso", "musculacion", "Remo");
    Ejercicio ejercicio22 = new Ejercicio(22,"Rodillas Arriba", R.drawable.dificultad_tres, 15, R.drawable.ejercicio_rodillas_arriba, videoRodillas, "x12", "Piernas", "musculacion", "Remo");


}
