package com.example.marcos.appejercicios.View.DondeEntreno;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.DAO.DaoPlaza;
import com.example.marcos.appejercicios.Model.Plaza;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorDndeEntreno;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerLugares extends Fragment {
    //Atts
    List<Plaza> listaPlazas;

    public FragmentRecyclerLugares() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DaoPlaza daoPlaza = new DaoPlaza();
        listaPlazas = daoPlaza.obtenerPlazas();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_recycler_lugares, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerDndeEntreno);
        //Le paso al adaptador del RecyclerEjs la lista de Ejercicios
        AdaptadorDndeEntreno adaptadorEjercicios = new AdaptadorDndeEntreno(getContext(), listaPlazas);
        recyclerView.setAdapter(adaptadorEjercicios);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;

    }

}
