package com.example.marcos.appejercicios.View.Rutinas;


import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.example.marcos.appejercicios.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleVideo extends Fragment {
    public static final String CLAVE_VIDEO = "Clave video";
    private Context context;
    private InterfaceBoton interfaceBoton;
    public FragmentDetalleVideo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_detalle_video, container, false);

        context = getContext();
        interfaceBoton = (InterfaceBoton) context;

        VideoView videoView = view.findViewById(R.id.videoDetalleRutina);
        Button button = view.findViewById(R.id.buttonVolverVideo);
        Bundle bundle = getArguments();
        Uri uri1 = Uri.parse(bundle.getString(CLAVE_VIDEO));
        videoView.setVideoURI(uri1);
        videoView.requestFocus();
        videoView.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceBoton.volverDelVideo();
            }
        });

        return view;
    }

    public interface InterfaceBoton{
        public void volverDelVideo();
    }
}
