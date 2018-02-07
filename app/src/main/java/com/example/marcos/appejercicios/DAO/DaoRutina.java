package com.example.marcos.appejercicios.DAO;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.Rutina;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcos on 24-Jan-18.
 */

public class DaoRutina {


    //Lista de ID delos ejercicios
    List<Integer> lista1 = new ArrayList<>(Arrays.asList(7,11));
    List<Integer> lista2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 8, 10, 12));
    List<Integer> lista3 = new ArrayList<>(Arrays.asList(5,6));

    public ArrayList<Rutina> obtenerRutinas (){
        ArrayList<Rutina> rutinaList = new ArrayList<>();
        rutinaList.add(rutina1);
        rutinaList.add(rutina2);
        rutinaList.add(rutina3);
        rutinaList.add(rutina4);
        rutinaList.add(rutina5);
        return rutinaList;
    }

    public List<Rutina> obtenerRutinasTipo(String tipo){
       ArrayList<Rutina> listRutinas = obtenerRutinas();
       ArrayList<Rutina> rutinasBuscadas = new ArrayList<>();
       for(Rutina rutina: listRutinas){
           if(rutina.getTipo().equals(tipo)){
               rutinasBuscadas.add(rutina);
           }
       }
       return rutinasBuscadas;
    }



    //Creo las Rutinas
    Rutina rutina1 = new Rutina("Antilope", R.drawable.dificultad_tres, 15, lista1, lista2, lista3, "1 Minuto", R.drawable.musculacion, "Aerobico", "Gluteos", "Descripcion de la rutina" );
    Rutina rutina2 = new Rutina("Bison", R.drawable.dificultad_dos, 20, lista1, lista2, lista3, "1 Minuto", R.drawable.musculacion, "Funcional", "Tronco Inferior", "Descripcion de la rutina" );
    Rutina rutina3 = new Rutina("Elefante", R.drawable.dificultad_uno, 30, lista1, lista2, lista3, "1 Minuto", R.drawable.musculacion, "Musculación", "Biceps, Triceps", "Descripcion de la rutina" );
    Rutina rutina4 = new Rutina("Jaguar", R.drawable.dificultad_dos, 15, lista1, lista2, lista3, "1 Minuto", R.drawable.musculacion, "Funcional", "Piernas", "Descripcion de la rutina" );
    Rutina rutina5 = new Rutina("Rinoceronte", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "1 Minuto", R.drawable.musculacion, "Musculación", "Cuadriceps", "Descripcion de la rutina" );

}
