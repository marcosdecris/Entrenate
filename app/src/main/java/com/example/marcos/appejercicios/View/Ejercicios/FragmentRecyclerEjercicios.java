package com.example.marcos.appejercicios.View.Ejercicios;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerEjercicios extends Fragment {
    //Atts
    public static final String CLAVE_TIPOEJ = "tipoEj";
    private List<Ejercicio> listaEjercicios;
    private Bundle bundle;
    private View view;
    private ImageView imageViewFotoTipo;

    //Constructores
    public FragmentRecyclerEjercicios() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Obtengo el Tipo de Ejercicio
        bundle = getArguments();
        String tipoEj = bundle.getString(CLAVE_TIPOEJ);

        //Obtengo los Ejercicios que corresponden a ese tipo
        DaoEjercicio daoEjercicio = new DaoEjercicio();
        listaEjercicios =  daoEjercicio.buscarEjsTipo(tipoEj);

        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_fragment_recycler_ejercicios, container, false);
       RecyclerView recyclerView = view.findViewById(R.id.recyclerEjercicios);

        //Cargo la foto de Tipo de Ejercicio
        imageViewFotoTipo = view.findViewById(R.id.imageViewTipoEjercicio);
        cargarImagenTipo(tipoEj);

       //Le paso al adaptador del RecyclerEjs la lista de Ejercicios
       AdaptadorEjercicios adaptadorEjercicios = new AdaptadorEjercicios(getContext(), listaEjercicios);
       recyclerView.setAdapter(adaptadorEjercicios);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
       recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }



    //Factory
    public static FragmentRecyclerEjercicios factory(String tipoEj){
        FragmentRecyclerEjercicios fragmentRecEj = new FragmentRecyclerEjercicios();
        Bundle bundle = new Bundle();
        bundle.putString(CLAVE_TIPOEJ, tipoEj);
        fragmentRecEj.setArguments(bundle);
        return fragmentRecEj;
    }

    //Cargar foto Encabezado tipo
    public void cargarImagenTipo(String tipoEj){
        if(tipoEj == "aerobico"){
            imageViewFotoTipo.setImageResource(R.drawable.aerobico);
        }if(tipoEj == "funcional"){
            imageViewFotoTipo.setImageResource(R.drawable.funcional);
        }if(tipoEj == "musculacion"){
            imageViewFotoTipo.setImageResource(R.drawable.musculacion);
        }
    }

}
