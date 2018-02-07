package com.example.marcos.appejercicios.DAO;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 01-Feb-18.
 */

public class DaoEjCalentamiento {
    List<Ejercicio> ejercicioList = new ArrayList<>();

    //Buscar todos los Ejercicios
    public List<Ejercicio> buscarTodosEjsCale( ){
        ejercicioList.add(ejercicio7);
        ejercicioList.add(ejercicio11);
        return ejercicioList;
    }


    //Buscar EjercicioS por id
    public List<Ejercicio> buscarEjsCalId(List<Integer> idList){
        List<Ejercicio> listaEjercicioId = new ArrayList<>();
        List<Ejercicio> listaglobal = buscarTodosEjsCale();
        for(Integer id: idList){
            for(Ejercicio ejercicio: listaglobal){
                if(ejercicio.getId().equals(id)){
                    listaEjercicioId.add(ejercicio);
                }
            }
        }

        return listaEjercicioId;
    }


    //Variables para videos
    String videoJumping = "android.resource://com.example.marcos.appejercicios/" + R.raw.jumping_jacks;
    String videoRodillas = "android.resource://com.example.marcos.appejercicios/" + R.raw.rodillas_arriba;


    //Hardcore
    Ejercicio ejercicio7 = new Ejercicio(7,"Jumping Jacks", R.drawable.nivelcinco, 15, R.drawable.ejercicio_brazos_5, videoJumping, "15 Minutos", "Piernas", "funcional", "Remo");
    Ejercicio ejercicio11 = new Ejercicio(11,"Rodillas Arriba", R.drawable.nivelcinco, 15, R.drawable.ejercicio_flexiones, videoRodillas, "15 Minutos", "Piernas", "funcional", "Remo");



}
