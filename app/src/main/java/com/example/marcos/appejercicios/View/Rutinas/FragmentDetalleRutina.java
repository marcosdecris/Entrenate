package com.example.marcos.appejercicios.View.Rutinas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.marcos.appejercicios.DAO.DaoEjCalentamiento;
import com.example.marcos.appejercicios.DAO.DaoEjEstiramiento;
import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.PadreExpandable;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorExpandableRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleRutina extends Fragment {
    public static final String CLAVE_DETALLE_RUTINA = "clave_detalle_rutina";
    public static final String CLAVE_DETALLE_ESTIRAMIENTO = "clave_detalle_estiramiento";
    public static final String CLAVE_DETALLE_CALENTAMIENTO = "calentamiento";
    private List<Integer> listaIdsEjsRtna;
    private List<Integer> listaIdsEjsCalent;
    private List<Integer> listaIdsEjsEstir;
    private List<Ejercicio> listaDeEjerciciosRutina;
    private List<Ejercicio> listaDeEjerciciosCalent;
    private List<Ejercicio> listaDeEjerciciosEstir;
    private List<Object> listaHijoRutina1;
    private List<Object> listaHijoRutina2;
    private List<Object> listaHijoRutina3;
    private PadreExpandable padreExpandable1;
    private PadreExpandable padreExpandable2;
    private PadreExpandable padreExpandable3;
    private Button btnEmpezar;
    private EmpezarRtna empezarRtna;


    public FragmentDetalleRutina() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Obtengo el Bundle
        Bundle bundle = getArguments();
        listaIdsEjsCalent = bundle.getIntegerArrayList(CLAVE_DETALLE_CALENTAMIENTO);
        listaIdsEjsRtna = bundle.getIntegerArrayList(CLAVE_DETALLE_RUTINA);
        listaIdsEjsEstir = bundle.getIntegerArrayList(CLAVE_DETALLE_ESTIRAMIENTO);
        empezarRtna = (EmpezarRtna) getContext();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_detalle_rutina, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerRutinasExpandable);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Creamos los padres : Fasedeentrenamiento
        padreExpandable1 = new PadreExpandable("Calentamiento");
        padreExpandable2 = new PadreExpandable("Rutina");
        padreExpandable3 = new PadreExpandable("Elongacion");

        //Cargamos cada padre con su lista de Ejercicios correspondiente
        cargarPadre1();
        cargarPadre2();
        cargarPadre3();

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

        btnEmpezar = view.findViewById(R.id.btnEmpezar);
        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empezarRtna.comenzarRutina(listaIdsEjsCalent, listaIdsEjsRtna, listaIdsEjsEstir);
            }
        });
        return view;
    }

    //Cargamos cada padre con su lista de Ejercicios correspondiente
    public void cargarPadre1() {
        //Traigo los Ejercicios
        DaoEjCalentamiento daoEjCalentamiento = new DaoEjCalentamiento();
        listaDeEjerciciosCalent = daoEjCalentamiento.buscarEjsCalId(listaIdsEjsCalent);

        //Le paso la lista de Ejercicios al Padre2
        listaHijoRutina1 = new ArrayList<>();
        for (Ejercicio ejercicio : listaDeEjerciciosCalent) {
            listaHijoRutina1.add(ejercicio);
        }
        padreExpandable1.setChildObjectList(listaHijoRutina1);
    }

    public void cargarPadre2() {
        //Traigo los Ejercicios
        DaoEjercicio daoEjercicio = new DaoEjercicio();
        listaDeEjerciciosRutina = daoEjercicio.buscarEjsPorId(listaIdsEjsRtna);

        //Le paso la lista de Ejercicios al Padre2
        listaHijoRutina2 = new ArrayList<>();
        for (Ejercicio ejercicio : listaDeEjerciciosRutina) {
            listaHijoRutina2.add(ejercicio);
        }
        padreExpandable2.setChildObjectList(listaHijoRutina2);
    }

    public void cargarPadre3() {

        //Traigo los Ejercicios
        DaoEjEstiramiento daoEjEstiramiento = new DaoEjEstiramiento();
        listaDeEjerciciosEstir = daoEjEstiramiento.buscarEjsEstiId(listaIdsEjsEstir);

        //Le paso la lista de Ejercicios al Padre2
        listaHijoRutina3 = new ArrayList<>();
        for (Ejercicio ejercicio : listaDeEjerciciosEstir) {
            listaHijoRutina3.add(ejercicio);
        }
        padreExpandable3.setChildObjectList(listaHijoRutina3);
    }

    //Interface
    public interface EmpezarRtna{
        public void comenzarRutina(List<Integer> listaIdsEjsCal, List<Integer> listaIdsEjsRtna, List<Integer> listaIdsEjesEsti);
    }
}




