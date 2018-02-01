package com.example.marcos.appejercicios.DAO;

import com.example.marcos.appejercicios.Model.Plaza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 24-Jan-18.
 */

public class DaoPlaza {

    public List<Plaza> obtenerPlazas(){
     List<Plaza> listaPlazas = new ArrayList<>();
     listaPlazas.add(plaza1);
     listaPlazas.add(plaza2);
     listaPlazas.add(plaza3);
     listaPlazas.add(plaza4);
     listaPlazas.add(plaza5);
        return listaPlazas;
    }






    Plaza plaza1 = new Plaza("Parque Centenario", " Antonio Machado y Leopoldo Marechal");
    Plaza plaza2 = new Plaza("Parque Chacabuco", "Emilio Mitre y Av. Asamblea");
    Plaza plaza3 = new Plaza("Plaza Rubén Darío", "Av. Del Libertador y Dr. Luis Agote");
    Plaza plaza4 = new Plaza("Parque Patricios", "Patagones y Monteagudo");
    Plaza plaza5 = new Plaza("Parque Indoamericano", " Av. Castañares y Av. Escalada");
}
