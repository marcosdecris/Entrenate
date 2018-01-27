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
    List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    List<Integer> lista2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
    List<Integer> lista3 = new ArrayList<>(Arrays.asList(1));

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
    Rutina rutina1 = new Rutina("Antilope", R.drawable.niveluno, 15, lista1, R.drawable.antilope2, "1 Minuto", R.drawable.aerobico, "Aerobico", "Gluteos" );
    Rutina rutina2 = new Rutina("Bison", R.drawable.niveldos, 20, lista2, R.drawable.bison, "1 Minuto", R.drawable.funcional, "Funcional", "Tronco Inferior" );
    Rutina rutina3 = new Rutina("Elefante", R.drawable.nivelcuatro, 30, lista1, R.drawable.elephant, "1 Minuto", R.drawable.musculacion, "Musculación", "Biceps, Triceps" );
    Rutina rutina4 = new Rutina("Jaguar", R.drawable.niveltres, 15, lista3, R.drawable.jaguar, "1 Minuto", R.drawable.funcional, "Funcional", "Piernas" );
    Rutina rutina5 = new Rutina("Rinoceronte", R.drawable.nivelcinco, 40, lista1, R.drawable.rhino, "1 Minuto", R.drawable.musculacion, "Musculación", "Cuadriceps" );

}
