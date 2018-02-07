package com.example.marcos.appejercicios.View.Rutinas;


import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.marcos.appejercicios.DAO.DaoEjCalentamiento;
import com.example.marcos.appejercicios.DAO.DaoEjEstiramiento;
import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.Model.Cronometro;
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
    private Integer posicion = 0;
    private Long lastPause;

    VideoView videoView;
    TextView textViewEjActualRtna;
    TextView textViewEjSiguiente;
    Chronometer cronometro;
    Button botonEmpezar;
    Button botonSiguiente;
    Button botonFinalizar;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Obtengo el bundle
        Bundle bundle = getArguments();
        listaIdsEjsCalent = bundle.getIntegerArrayList(CLAVE_DETALLE_CALENTAMIENTO);
        listaIdsEjsRtna = bundle.getIntegerArrayList(CLAVE_DETALLE_RUTINA);
        listaIdsEjsEstir = bundle.getIntegerArrayList(CLAVE_DETALLE_ESTIRAMIENTO);

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_fragment_ejercicio_rutina, container, false);
        LinearLayout layout = view.findViewById(R.id.layoutBotonRutina);
        videoView = view.findViewById(R.id.videoViewRtna);
        textViewEjActualRtna = view.findViewById(R.id.textViewTEjACtual);
        textViewEjSiguiente = view.findViewById(R.id.textViewEjProximo);

        //Traigo los ejercicios y los guardo en cada lista
        cargarListasEjs();
        //Hago una lista global de ejercicios
        cargarlistaGlobal();


        //Busco los botones
        botonEmpezar = view.findViewById(R.id.buttonStart);
        botonSiguiente = view.findViewById(R.id.buttonSiguiente);
        botonFinalizar = view.findViewById(R.id.buttonFinalizar);
        cronometro = view.findViewById(R.id.cronometro);
        final Button botonPausa = view.findViewById(R.id.botonPausa);
        final Button botonContinuar = view.findViewById(R.id.botonResumir);

        botonSiguiente.setEnabled(false);
        botonSiguiente.setVisibility(view.GONE);
        botonFinalizar.setEnabled(false);
        botonFinalizar.setVisibility(view.VISIBLE);
        botonPausa.setEnabled(false);
        botonPausa.setVisibility(view.INVISIBLE);
        botonContinuar.setEnabled(false);
        botonContinuar.setVisibility(view.INVISIBLE);





        //Metodo para el boton empezar
        botonEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cronometro.setBase(SystemClock.elapsedRealtime());
                cronometro.start();
                botonPausa.setVisibility(view.VISIBLE);
                botonPausa.setEnabled(true);
                cargarEjercicio();
                botonEmpezar.setEnabled(false);
                botonEmpezar.setVisibility(v.GONE);
                botonSiguiente.setEnabled(true);
                botonSiguiente.setVisibility(v.VISIBLE);
            }
        });

        //Metodo para el boton de ir al siguiente Ej
        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO pop up window q cuente de 5 a 0
                if(posicion == listaEjsGlobal.size() - 1){
                    botonSiguiente.setEnabled(false);
                    botonSiguiente.setVisibility(v.GONE);
                    botonFinalizar.setEnabled(true);
                    botonFinalizar.setVisibility(v.VISIBLE);
                    rutinaFinalizada();
                }else{
                    posicion = posicion + 1;
                    cargarEjercicio();

                }
            }
        });

        botonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO lo que haga el boton finalizar
                cronometro.stop();
                botonPausa.setEnabled(false);
                botonPausa.setVisibility(view.INVISIBLE);
            }
        });

        botonPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastPause = SystemClock.elapsedRealtime();
                cronometro.stop();
                botonPausa.setEnabled(false);
                botonPausa.setVisibility(view.INVISIBLE);
                botonContinuar.setEnabled(true);
                botonContinuar.setVisibility(view.VISIBLE);
            }
        });

        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cronometro.setBase(cronometro.getBase() + SystemClock.elapsedRealtime() - lastPause);
                cronometro.start();
                botonContinuar.setEnabled(false);
                botonContinuar.setVisibility(view.INVISIBLE);
                botonPausa.setVisibility(view.VISIBLE);
                botonPausa.setEnabled(true);
            }
        });

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

    public void cargarEjercicio( ){
        //Toma la posicion del ejercicio
       Ejercicio ejercicioActual =  listaEjsGlobal.get(posicion);
       Ejercicio siguienteEjercicio;
        if(posicion == listaEjsGlobal.size() - 1){
            textViewEjSiguiente.setText("Dale campeon que ya terminas");
        }else{
             siguienteEjercicio = listaEjsGlobal.get(posicion + 1);
            textViewEjSiguiente.setText(siguienteEjercicio.getNombre());
        }


       //Carga los datos del Ejercicio
        textViewEjActualRtna.setText(ejercicioActual.getNombre());
        Uri uri1 = Uri.parse(ejercicioActual.getVideo());
        videoView.setVideoURI(uri1);
        videoView.requestFocus();
        videoView.start();


    }

    public void rutinaFinalizada(){
        textViewEjSiguiente.setText("FINALIZADA");

    }

}
