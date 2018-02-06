package com.example.marcos.appejercicios.DAO;

import com.example.marcos.appejercicios.Model.Aparato;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcos on 24-Jan-18.
 */

public class DaoAparatos {
    //Lista de ID delos ejercicios
    List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    List<Integer> lista2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
    List<Integer> lista3 = new ArrayList<>(Arrays.asList(1));


    // TODO -- Borrar cuando se use Json
     public List<Aparato> obtenerAparatos (){
         List<Aparato> listaAparatos = new ArrayList<>();

         listaAparatos.add(aparato1);
         listaAparatos.add(aparato2);
         listaAparatos.add(aparato3);
         listaAparatos.add(aparato4);
         listaAparatos.add(aparato5);

         return listaAparatos;
     }



    Aparato aparato1 = new Aparato("Abdominales", R.drawable.niveluno, R.drawable.aparato_abdominales,"Gluteos", lista1 );
    Aparato aparato2 = new Aparato("Remo", R.drawable.niveldos, R.drawable.aparato_remo,"Brazos", lista2);
    Aparato aparato3 = new Aparato("Eliptica", R.drawable.nivelcinco, R.drawable.aparato_eliptica,"Piernas", lista1);
    Aparato aparato4 = new Aparato("Laterales", R.drawable.nivelcuatro, R.drawable.aparato_caderas,"Piernas/Gluteos", lista2);
    Aparato aparato5 = new Aparato("Multi Salto", R.drawable.niveltres, R.drawable.aparato_pasadas_2,"Tronco superior", lista3);









}
