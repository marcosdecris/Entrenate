package com.example.marcos.appejercicios.DAO;

import com.example.marcos.appejercicios.Model.Aparato;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marcos on 24-Jan-18.
 */

public class DaoAparatos {
    //Lista de ID delos ejercicios
    List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2));
    List<Integer> lista2 = new ArrayList<>(Arrays.asList(9, 10, 11, 12, 13, 14, 15, 8, 1, 2));
    List<Integer> lista3 = new ArrayList<>(Arrays.asList(16, 17, 18, 19, 20, 21, 22, 8, 1, 2));
    List<Integer> lista4 = new ArrayList<>(Arrays.asList(3, 14, 15, 19, 4, 5, 6, 8, 1, 2));
    List<Integer> lista5 = new ArrayList<>(Arrays.asList(16, 17,6, 7, 8, 1, 2, 3,  8, 1, 2));


    // TODO -- Borrar cuando se use Json
     public List<Aparato> obtenerAparatos (){
         List<Aparato> listaAparatos = new ArrayList<>();

         listaAparatos.add(aparato1);
         listaAparatos.add(aparato2);
         listaAparatos.add(aparato3);
         listaAparatos.add(aparato4);
         listaAparatos.add(aparato5);
         listaAparatos.add(aparato6);
         listaAparatos.add(aparato7);
         listaAparatos.add(aparato8);
         listaAparatos.add(aparato9);
         return listaAparatos;
     }



    Aparato aparato1 = new Aparato("Plancha", R.drawable.aparato_abdominales,"Abdominales", lista1 );
    Aparato aparato2 = new Aparato("Barra", R.drawable.aparato_barra,"Brazos", lista2);
    Aparato aparato3 = new Aparato("Barras Paralelas", R.drawable.aparato_barras_paralelas,"Triceps", lista3);
    Aparato aparato4 = new Aparato("Ascensor", R.drawable.aparato_ascensor,"Espalda", lista4);
    Aparato aparato5 = new Aparato("Elíptica",  R.drawable.aparato_eliptica,"Izquiotibiales", lista5);
    Aparato aparato6 = new Aparato("Pasadas",  R.drawable.aparato_pasadas,"Resistencia", lista5);
    Aparato aparato7 = new Aparato("Remo",  R.drawable.aparato_remo,"Tronco superior", lista2);
    Aparato aparato8 = new Aparato("Surf",  R.drawable.aparato_surf,"Laterales", lista3);
    Aparato aparato9 = new Aparato("Prensa",  R.drawable.aparatos_prensa,"Gemelos", lista4);










}
