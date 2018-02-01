package com.example.marcos.appejercicios.View.Rutinas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.marcos.appejercicios.DAO.DaoEjCalentamiento;
import com.example.marcos.appejercicios.DAO.DaoEjEstiramiento;
import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEjercicioRutina extends Fragment {
    //Atts
    public static final String CLAVE_DETALLE_RUTINA = "clave_detalle_rutina";
    public static final String CLAVE_DETALLE_ESTIRAMIENTO = "clave_detalle_estiramiento";
    public static final String CLAVE_DETALLE_CALENTAMIENTO = "calentamiento";
    private List<Integer> listaIdsEjsRtna;
    private List<Integer> listaIdsEjsCalent;
    private List<Integer> listaIdsEjsEstir;
    private List<Ejercicio> listaDeEjerciciosRutina;
    private List<Ejercicio> listaDeEjerciciosCalent;
    private List<Ejercicio> listaDeEjerciciosEstir;
    private List<Ejercicio> listaEjsGlobal = new ArrayList<>();

    public FragmentEjercicioRutina() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Obtengo el bundle
        Bundle bundle = getArguments();
        listaIdsEjsCalent = bundle.getIntegerArrayList(CLAVE_DETALLE_CALENTAMIENTO);
        listaIdsEjsRtna = bundle.getIntegerArrayList(CLAVE_DETALLE_RUTINA);
        listaIdsEjsEstir = bundle.getIntegerArrayList(CLAVE_DETALLE_ESTIRAMIENTO);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_ejercicio_rutina, container, false);
        VideoView videoView = view.findViewById(R.id.videoViewRtna);
        TextView textViewNombEjRtna = view.findViewById(R.id.textViewRtnaNombEj);

        //Traigo los ejercicios y los guardo en cada lista
        cargarListasEjs();
        //Hago una lista global de ejercicios
        cargarlistaGlobal();



        return view;
    }


    //Traigo los ejercicios y los guardo en cada lista
    public void cargarListasEjs(){
        //Lista Calentamiento
        DaoEjCalentamiento daoEjCalentamiento = new DaoEjCalentamiento();
        listaDeEjerciciosCalent = daoEjCalentamiento.buscarEjsCalId(listaIdsEjsCalent);

        //Lista Ejercicios Rutina
        DaoEjercicio daoEjercicio = new DaoEjercicio();
        listaDeEjerciciosRutina = daoEjercicio.buscarEjsPorId(listaIdsEjsRtna);

        //Lista Ejercicios Estiramiento
        DaoEjEstiramiento daoEjEstiramiento = new DaoEjEstiramiento();
        listaDeEjerciciosEstir = daoEjEstiramiento.buscarEjsEstiId(listaIdsEjsEstir);

    }

    //Cargo las diferentes listas
    public void cargarlistaGlobal(){
        for(Ejercicio ejercicio: listaDeEjerciciosCalent){
            listaEjsGlobal.add(ejercicio);
        } for(Ejercicio ejercicio: listaDeEjerciciosRutina){
            listaEjsGlobal.add(ejercicio);
        } for(Ejercicio ejercicio: listaDeEjerciciosEstir){
            listaEjsGlobal.add(ejercicio);
        }

    }

}
