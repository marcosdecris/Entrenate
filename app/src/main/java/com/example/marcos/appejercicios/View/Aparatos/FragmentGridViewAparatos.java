package com.example.marcos.appejercicios.View.Aparatos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marcos.appejercicios.DAO.DaoAparatos;
import com.example.marcos.appejercicios.Model.Aparato;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorGrid;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGridViewAparatos extends Fragment {
    //Atts
    private ArrayList<Aparato> listaAparatos;

    //Constructor
    public FragmentGridViewAparatos() {
        // Required empty public constructor
    }

    //Metodos
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view_aparatos, container, false);

        //Obtengo los aparatos y se los paso al adaptador del Grid
        DaoAparatos daoAparatos = new DaoAparatos();
        listaAparatos = (ArrayList<Aparato>) daoAparatos.obtenerAparatos();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerGridAparatos);
        AdaptadorGrid adaptadorGrid = new AdaptadorGrid(getContext(), listaAparatos);
        recyclerView.setAdapter(adaptadorGrid);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        return view;
    }

}
