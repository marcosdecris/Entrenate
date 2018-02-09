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
        rutinaList.add(rutina6);
        rutinaList.add(rutina7);
        rutinaList.add(rutina8);
        rutinaList.add(rutina9);
        rutinaList.add(rutina10);
        rutinaList.add(rutina11);
        rutinaList.add(rutina12);
        rutinaList.add(rutina13);
        rutinaList.add(rutina14);
        rutinaList.add(rutina15);
        rutinaList.add(rutina16);
        rutinaList.add(rutina17);
        rutinaList.add(rutina18);
        rutinaList.add(rutina19);
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
    Rutina rutina1 = new Rutina("Rutina I", R.drawable.dificultad_tres, 15, lista1, lista2, lista3, "30 Minutos", R.drawable.aerobico, "Aerobico", "Gluteos", "Descripcion de la rutina" );
    Rutina rutina2 = new Rutina("Rutina II", R.drawable.dificultad_dos, 20, lista1, lista2, lista3, "15 Minutos", R.drawable.funcional, "Funcional", "Triceps", "Descripcion de la rutina" );
    Rutina rutina3 = new Rutina("Rutina III", R.drawable.dificultad_uno, 30, lista1, lista2, lista3, "45 Minutos", R.drawable.musculacion, "Musculación", "Biceps", "Descripcion de la rutina" );
    Rutina rutina4 = new Rutina("Rutina IV", R.drawable.dificultad_dos, 15, lista1, lista2, lista3, "30 Minutos", R.drawable.funcional, "Funcional", "Piernas", "Descripcion de la rutina" );
    Rutina rutina5 = new Rutina("Rutina V", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "45 Minutos", R.drawable.musculacion, "Musculación", "Cuadriceps", "Descripcion de la rutina" );
    Rutina rutina6 = new Rutina("Rutina VI", R.drawable.dificultad_tres, 15, lista1, lista2, lista3, "15 Minutos", R.drawable.aerobico, "Aerobico", "Gluteos", "Descripcion de la rutina" );
    Rutina rutina7 = new Rutina("Rutina VII", R.drawable.dificultad_dos, 20, lista1, lista2, lista3, "30 Minutos", R.drawable.funcional, "Funcional", "Triceps", "Descripcion de la rutina" );
    Rutina rutina8 = new Rutina("Rutina VIII", R.drawable.dificultad_uno, 30, lista1, lista2, lista3, "45 Minutos", R.drawable.musculacion, "Musculación", "Biceps", "Descripcion de la rutina" );
    Rutina rutina9 = new Rutina("Rutina IX", R.drawable.dificultad_dos, 15, lista1, lista2, lista3, "30 Minutos", R.drawable.funcional, "Funcional", "Piernas", "Descripcion de la rutina" );
    Rutina rutina10 = new Rutina("Rutina X", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "45 Minutos", R.drawable.musculacion, "Musculación", "Cuadriceps", "Descripcion de la rutina" );
    Rutina rutina11 = new Rutina("Rutina XI", R.drawable.dificultad_tres, 15, lista1, lista2, lista3, "30 Minutos", R.drawable.aerobico, "Aerobico", "Gluteos", "Descripcion de la rutina" );
    Rutina rutina12 = new Rutina("Rutina XII", R.drawable.dificultad_dos, 20, lista1, lista2, lista3, "45 Minutos", R.drawable.funcional, "Funcional", "Triceps", "Descripcion de la rutina" );
    Rutina rutina13 = new Rutina("Rutina XIII", R.drawable.dificultad_uno, 30, lista1, lista2, lista3, "15 Minutos", R.drawable.musculacion, "Musculación", "Biceps ", "Descripcion de la rutina" );
    Rutina rutina14 = new Rutina("Rutina XIV", R.drawable.dificultad_dos, 15, lista1, lista2, lista3, "30 Minutos", R.drawable.funcional, "Funcional", "Piernas", "Descripcion de la rutina" );
    Rutina rutina15 = new Rutina("Rutina XV", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "15 Minutos", R.drawable.musculacion, "Musculación", "Cuadriceps", "Descripcion de la rutina" );
    Rutina rutina16 = new Rutina("Rutina XVI", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "30 Minutos", R.drawable.aerobico, "Aerobico", "Resistencia", "Descripcion de la rutina" );
    Rutina rutina17 = new Rutina("Rutina XVII", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "15Minutos", R.drawable.aerobico, "Aerobico", "Abdomen", "Descripcion de la rutina" );
    Rutina rutina18 = new Rutina("Rutina XVIII", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "30 Minutos", R.drawable.aerobico, "Aerobico", "Resistencia", "Descripcion de la rutina" );
    Rutina rutina19 = new Rutina("Rutina XIX", R.drawable.dificultad_tres, 40, lista1, lista2, lista3, "45 Minutos", R.drawable.aerobico, "Aerobico", "Cuadriceps", "Descripcion de la rutina" );


}
