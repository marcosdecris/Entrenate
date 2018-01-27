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



    Aparato aparato1 = new Aparato("Andador", R.drawable.niveluno, R.drawable.aparato1,"Gluteos", lista1 );
    Aparato aparato2 = new Aparato("Remo", R.drawable.niveldos, R.drawable.aparato2,"Brazos", lista2);
    Aparato aparato3 = new Aparato("Eliptica", R.drawable.nivelcinco, R.drawable.aparato3,"Piernas", lista1);
    Aparato aparato4 = new Aparato("Bicicleta", R.drawable.nivelcuatro, R.drawable.aparato4,"Piernas/Gluteos", lista2);
    Aparato aparato5 = new Aparato("Barra", R.drawable.niveltres, R.drawable.aparato5,"Tronco superior", lista3);








}
