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
    List<Integer> listaPlancha = new ArrayList<>(Arrays.asList(30,31, 32, 33, 34, 35, 36, 37, 38));
    List<Integer> listaBarra = new ArrayList<>(Arrays.asList(40, 41, 42, 43, 44, 45, 46, 47, 48));
    List<Integer> listaParalelas = new ArrayList<>(Arrays.asList(60, 61, 62, 63, 64, 65, 66, 67, 68));
    List<Integer> listaAscensor = new ArrayList<>(Arrays.asList(50, 51, 52, 53, 54, 55, 56, 57, 58));
    List<Integer> listaEliptica = new ArrayList<>(Arrays.asList(80, 81, 82, 83, 84, 85, 86, 87, 88));
    List<Integer> listaPasadas = new ArrayList<>(Arrays.asList(70, 71, 72, 73, 74, 75, 76, 77, 78));
    List<Integer> listaRemo= new ArrayList<>(Arrays.asList(100, 101, 102, 103, 104, 105, 106, 107, 108));
    List<Integer> listaSurf = new ArrayList<>(Arrays.asList(90, 91, 92, 93, 94, 95, 96, 97, 98));



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
         return listaAparatos;
     }



    Aparato aparato1 = new Aparato("Plancha", R.drawable.aparato_abdominales,"Abdominales", listaPlancha );
    Aparato aparato2 = new Aparato("Barra", R.drawable.aparato_barra,"Brazos", listaBarra);
    Aparato aparato3 = new Aparato("Barras Paralelas", R.drawable.aparato_barras_paralelas,"Triceps", listaParalelas);
    Aparato aparato4 = new Aparato("Ascensor", R.drawable.aparato_ascensor,"Espalda", listaAscensor);
    Aparato aparato5 = new Aparato("Elíptica",  R.drawable.aparato_eliptica,"Izquiotibiales", listaEliptica);
    Aparato aparato6 = new Aparato("Pasadas",  R.drawable.aparato_pasadas,"Resistencia", listaPasadas);
    Aparato aparato7 = new Aparato("Remo",  R.drawable.aparato_remo,"Tronco superior", listaRemo);
    Aparato aparato8 = new Aparato("Surf",  R.drawable.aparato_surf,"Laterales", listaSurf);



}
