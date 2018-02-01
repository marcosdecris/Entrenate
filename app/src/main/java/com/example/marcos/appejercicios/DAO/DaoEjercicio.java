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
        return ejercicioList;
    }

    //Buscar Ejercicio por tipo (Musculacion, aerobicos)
    public List<Ejercicio> buscarEjsTipo(String tipoEj){
        ejercicioList.add(ejercicio1);
        ejercicioList.add(ejercicio2);
        ejercicioList.add(ejercicio3);
        ejercicioList.add(ejercicio4);
        ejercicioList.add(ejercicio5);
        return ejercicioList;
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
    String video1 = "android.resource://com.example.marcos.appejercicios/"+ R.raw.prueba;
    String video2 = "android.resource://com.example.marcos.appejercicios/"+ R.raw.prueba2;



    //Hardcore
    Ejercicio ejercicio1 = new Ejercicio(1,"Cinta", R.drawable.niveluno, 15, R.drawable.ejercicio1, video1, "15 Minutos", "Piernas", "aerobico", "Andador");
    Ejercicio ejercicio2 = new Ejercicio(2,"Pectorales", R.drawable.nivelcuatro, 15, R.drawable.ejercicio2bis, video2, "15 Minutos", "Piernas", "musculacion", "Remo" );
    Ejercicio ejercicio3 = new Ejercicio(3,"Escalador", R.drawable.niveldos, 15, R.drawable.ejercicio3, video1, "15 Minutos", "Piernas", "aerobico", "nu");
    Ejercicio ejercicio4 = new Ejercicio(4,"Mancuerna", R.drawable.niveltres, 25, R.drawable.ejercicio4, video2, "15 Minutos", "Piernas", "musculacion", "Andador");
    Ejercicio ejercicio5 = new Ejercicio(5,"Bicicleta", R.drawable.nivelcinco, 15, R.drawable.ejercicio5, video2, "15 Minutos", "Piernas", "aerobico", "Andador");
    Ejercicio ejercicio6 = new Ejercicio(6,"Bicicleta", R.drawable.nivelcinco, 15, R.drawable.ejercicio5, video1, "15 Minutos", "Piernas", "funcional", "Andador");
    Ejercicio ejercicio7 = new Ejercicio(7,"Bicicleta", R.drawable.nivelcinco, 15, R.drawable.ejercicio5, video1, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio8 = new Ejercicio(8,"Bicicleta", R.drawable.nivelcinco, 15, R.drawable.ejercicio5, video2, "15 Minutos", "Piernas", "funcional", "Remo");
}
