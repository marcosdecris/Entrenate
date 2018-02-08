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
    String videoEstiramientoUno = "android.resource://com.example.marcos.appejercicios/"+ R.raw.estiramiento_1;
    String videoEstiramientoAb = "android.resource://com.example.marcos.appejercicios/"+ R.raw.estiramiento_abdominales;

    //Hardcore
    Ejercicio ejercicio5 = new Ejercicio(5,"Estiramiento Brazos", R.drawable.dificultad_dos, 15, R.drawable.estiramiento_brazos, videoEstiramientoUno, "x12", "Piernas", "aerobico", "Andador");
    Ejercicio ejercicio6 = new Ejercicio(6,"Estiramiento Abdominales", R.drawable.dificultad_uno, 15, R.drawable.estiramiento_gluteos, videoEstiramientoAb, "x12", "Piernas", "funcional", "Andador");
}