package com.example.marcos.appejercicios.View.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.Rutina;
import com.example.marcos.appejercicios.R;

import java.util.List;

/**
 * Created by Marcos on 26-Jan-18.
 */

public class AdaptadorRecycRutinas extends RecyclerView.Adapter<AdaptadorRecycRutinas.MyRecyclerViewHolder> {
    //Atts
    private Context context;
    private List<Rutina> listaRutinas;
    private ComunicadorRutinas comunicadorRutinas;

    //Constructor
    public AdaptadorRecycRutinas(Context context, List<Rutina> listaRutinas) {
        this.context = context;
        this.listaRutinas = listaRutinas;
        this.comunicadorRutinas = (ComunicadorRutinas) context;
    }

    @Override
    public AdaptadorRecycRutinas.MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creo el inflados
        LayoutInflater inflador = LayoutInflater.from(context);
        //inflo la vista
        View view = inflador.inflate(R.layout.celda_recycler_rutinas, parent, false);
        //Instancio el viewholder
        AdaptadorRecycRutinas.MyRecyclerViewHolder holder = new AdaptadorRecycRutinas.MyRecyclerViewHolder(view);
        //Devuelvo la vista
        return holder;

    }

    @Override
    public void onBindViewHolder(AdaptadorRecycRutinas.MyRecyclerViewHolder holder, int position) {
        final Rutina rutina = listaRutinas.get(position);
        holder.bindCelda(rutina);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO -- Metodo para ir a detalle
                comunicadorRutinas.irADetalle(rutina.getListaEjsCalentamiento(), rutina.getListaEjercicios(), rutina.getListaEjesEstiramiento());
            }
        });
    }



    @Override
    public int getItemCount() {
        return listaRutinas.size();
    }


    //Creo la clase viewholder
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        //Atts viewholder
        private TextView nombre;
        private TextView zonaTrabaja;
        private TextView tiempoEstimado;
        private ImageView logo;
        private ImageView dificultad;
        private FrameLayout layout;


        //Constructror viewholder
        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewCeldaRutinaNombre);
            zonaTrabaja = itemView.findViewById(R.id.textViewCeldaRutinaZonaTrabaja);
            tiempoEstimado = itemView.findViewById(R.id.textViewCeldaRutinaTiempo);
            logo = itemView.findViewById(R.id.imageViewLogoRutina);
            dificultad = itemView.findViewById(R.id.imageViewCeldaRutinaDificultad);
            layout = itemView.findViewById(R.id.celdaRutinaLayout);
        }

        //Metodos viewholder
        public void bindCelda (Rutina rutina){
            nombre.setText(rutina.getNombre());
            zonaTrabaja.setText(rutina.getZonaQueTrabaja());
            logo.setImageResource(rutina.getLogo());
            dificultad.setImageResource(rutina.getDificultad());
            tiempoEstimado.setText(rutina.getDuracionEstimada());
//            RequestOptions ro = new RequestOptions().placeholder(R.drawable.loading4).error(R.drawable.errornews);
//            Glide.with(context).load(unaNoticia.getUrlImagen()).apply(ro).into(imagen);
        }

    }

    public interface ComunicadorRutinas {
        public void irADetalle(List<Integer> listaEjsCal, List<Integer> listaEjercicios, List<Integer> listaEjsEstir);
    }
}
