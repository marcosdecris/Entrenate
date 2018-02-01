package com.example.marcos.appejercicios.View.Rutinas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.DAO.DaoRutina;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.PadreExpandable;
import com.example.marcos.appejercicios.Model.Rutina;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorExpandableRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleRutina extends Fragment {
    public static final String CLAVE_DETALLE_RUTINA = "clave_detalle_rutina";
    private List<Integer> listaIdsEjercicios;
    private  List<Ejercicio> listaDeEjerciciosRutina;
    private List<Object> listaHijoRutina;


    public FragmentDetalleRutina() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Obtengo el Ejercicio
        Bundle bundle = getArguments();
        listaIdsEjercicios = bundle.getIntegerArrayList(CLAVE_DETALLE_RUTINA);


        //Obtengo los Ejercicios que corresponden a ese tipo
        // TODO: 1/31/18 Traer los ejercicios por rutina
        
        
        
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_detalle_rutina, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerRutinasExpandable);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Creamos los padres : Fasedeentrenamiento
        PadreExpandable padreExpandable1 = new PadreExpandable("Calentamiento");
        PadreExpandable padreExpandable2 = new PadreExpandable("Rutina");
        PadreExpandable padreExpandable3 = new PadreExpandable("Elongacion");


        DaoEjercicio daoEjercicio = new DaoEjercicio();
        listaDeEjerciciosRutina = daoEjercicio.buscarEjsPorId(listaIdsEjercicios);


        listaHijoRutina = new ArrayList<>();

        for (Ejercicio ejercicio: listaDeEjerciciosRutina) {
            listaHijoRutina.add(ejercicio);
        }

        padreExpandable2.setChildObjectList(listaHijoRutina);


        //Armo una lista con los padres del tipo <ParentObject>
        ArrayList<ParentObject> listaPadre = new ArrayList<>();
        listaPadre.add(padreExpandable1);
        listaPadre.add(padreExpandable2);
        listaPadre.add(padreExpandable3);

        //Creo el adaptador y le paso la lista de padres
        AdaptadorExpandableRecycler adaptador = new AdaptadorExpandableRecycler(getContext(), listaPadre);
        //Permite que la flechita pueda rotar
        adaptador.setCustomParentAnimationViewId(R.id.iconoFlecha);
        //Le da un tiempo por default de x milisegundos
        adaptador.setParentClickableViewAnimationDefaultDuration();
        //Se asegura de que cuando apretes la flechita o to do el padre se expanda la lista
        adaptador.setParentAndIconExpandOnClick(true);
        //Seteo el recycler con el adaptador
        recyclerView.setAdapter(adaptador);

        return view;
    }

}
