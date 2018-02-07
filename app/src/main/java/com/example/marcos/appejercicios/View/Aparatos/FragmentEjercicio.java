package com.example.marcos.appejercicios.View.Aparatos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEjercicio extends Fragment {
    public static final String CLAVE_EJERCICIO = "ejercicio";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_ejercicio, container, false);

        //Encuentro las vistas
        VideoView video = view.findViewById(R.id.videoViewEjercicio);
        TextView nombre = view.findViewById(R.id.textViewNombreEj);
        TextView repeticiones = view.findViewById(R.id.cantidadDeRep);
        TextView rutinasAsociadas = view.findViewById(R.id.textViewRutinaEj);

        //Obtengo el Ejercicio
        Bundle bundle = getArguments();
        Ejercicio ejercicio = (Ejercicio) bundle.getSerializable(CLAVE_EJERCICIO);


        //Cargo los datos del Ejercicio
        Uri uri1 = Uri.parse(ejercicio.getVideo());
        video.setVideoURI(uri1);
        video.requestFocus();
        video.start();
        nombre.setText(ejercicio.getNombre());
        repeticiones.setText(ejercicio.getRepeticiones());

        return view;
    }



}
