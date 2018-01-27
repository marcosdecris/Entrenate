package com.example.marcos.appejercicios.View.Aparatos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerEjsAparatos extends Fragment {
    //Atts
    public static final String CLAVE_LISTAEJS = "listaEjs";
    private List<Integer> listaIdsEj;
    private List<Ejercicio> listaEjercicios = new ArrayList<>();

    //Constructor
    public FragmentRecyclerEjsAparatos() {
        // Required empty public constructor
    }

    //Metodos
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_recycler_ejs_aparatos, container, false);

        //Obtengo la lista de Ids de los Ejercicios que corresponen al aparato
        Bundle bundle = getArguments();
        listaIdsEj =  bundle.getIntegerArrayList(CLAVE_LISTAEJS);

        //Obtengo de la base de datos los Ejercicios que corresponden a los Ids obtenidos
        DaoEjercicio daoEjercicio = new DaoEjercicio();
        listaEjercicios =  daoEjercicio.buscarEjsPorId(listaIdsEj);

        //Le paso la lista de Ejercicios al Adaptador del RecyclerEjs
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerEjsAparatos);
        AdaptadorEjercicios adaptadorEjercicios = new AdaptadorEjercicios(getContext(), listaEjercicios);
        recyclerView.setAdapter(adaptadorEjercicios);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        return view;
    }



}
