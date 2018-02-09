package com.example.marcos.appejercicios.View.Rutinas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.DAO.DaoRutina;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.Rutina;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorRecycRutinas;
import com.example.marcos.appejercicios.View.Ejercicios.FragmentRecyclerEjercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerRutinas extends Fragment {
    public static final String CLAVE_TIPO_RUTINA = "tipoRut";
    private List<Rutina> listaRutinas;
    private Bundle bundle;
    private View view;
    private ImageView imageViewFotoTipo;



    public FragmentRecyclerRutinas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Obtengo el Tipo de Ejercicio
        bundle = getArguments();
        String tipoRutina = bundle.getString(CLAVE_TIPO_RUTINA);


       //Obtengo los Ejercicios que corresponden a ese tipo
        DaoRutina daoRutina = new DaoRutina();
        listaRutinas = daoRutina.obtenerRutinasTipo(tipoRutina);

        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_fragment_recycler_rutinas, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerRutinas);

        //Cargo la foto de Tipo de rutina
        imageViewFotoTipo = view.findViewById(R.id.imageViewTipoRutina);
        cargarImagenTipo(tipoRutina);

        //Le paso al adaptador del RecyclerEjs la lista de Ejercicios
        AdaptadorRecycRutinas adaptadorRecycRutinas = new AdaptadorRecycRutinas(getContext(), listaRutinas);
        recyclerView.setAdapter(adaptadorRecycRutinas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    //Factory
    public static FragmentRecyclerRutinas factory(String tipoRutina){
        FragmentRecyclerRutinas fragmentRecyclerRutinas = new FragmentRecyclerRutinas();
        Bundle bundle = new Bundle();
        bundle.putString(CLAVE_TIPO_RUTINA, tipoRutina);
        fragmentRecyclerRutinas.setArguments(bundle);
        return fragmentRecyclerRutinas;
    }


    public void cargarImagenTipo(String tipoRutina){
        if(tipoRutina == "Aerobico"){
           imageViewFotoTipo.setImageResource(R.drawable.aerobico);
        }if(tipoRutina == "Funcional"){
            imageViewFotoTipo.setImageResource(R.drawable.funcional);
        }if(tipoRutina == "Musculación"){
            imageViewFotoTipo.setImageResource(R.drawable.musculacion);
        }
    }


}
