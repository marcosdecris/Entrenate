package com.example.marcos.appejercicios.View.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Aparatos.ContenedorAparatos;
import com.example.marcos.appejercicios.View.Ejercicios.ContenedorEjercicios;

import java.util.List;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class AdaptadorEjercicios extends RecyclerView.Adapter<AdaptadorEjercicios.MyRecyclerViewHolder> {
    //Atts
    private Context context;
    private List<Ejercicio> listaEjercicio;
    private Comunicador2 comunicador2;

    //Constructor
    public AdaptadorEjercicios(Context context, List<Ejercicio> listaEjercicio) {
        this.context = context;
        this.listaEjercicio = listaEjercicio;
        this.comunicador2 = (Comunicador2) context;
    }


    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creo el inflados
        LayoutInflater inflador = LayoutInflater.from(context);
        //inflo la vista
        View view = inflador.inflate(R.layout.celda__recycler__ejercicios, parent, false);
        //Instancio el viewholder
        MyRecyclerViewHolder holder = new MyRecyclerViewHolder(view);
        //Devuelvo la vista
        return holder;

    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        final Ejercicio ejercicio = listaEjercicio.get(position);
        holder.bindCelda(ejercicio);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO -- Metodo para ir a detalle
                comunicador2.irAEjercicio(ejercicio);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listaEjercicio.size();
    }



    //Creo la clase viewholder
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        //Atts viewholder
        private TextView nombre;
        private TextView zonaTrabaja;
        private ImageView foto;
        private ImageView dificultad;
        private LinearLayout layout;


        //Constructror viewholder
        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewCeldaNombre);
            zonaTrabaja = itemView.findViewById(R.id.textViewCeldaZonaTrabaja);
            foto = itemView.findViewById(R.id.imageViewCeldaFoto);
            dificultad = itemView.findViewById(R.id.imageViewCeldaDificultad);
            layout = itemView.findViewById(R.id.celdaLayout);
        }

        //Metodos viewholder
        public void bindCelda (Ejercicio ejercicio){
            nombre.setText(ejercicio.getNombre());
            zonaTrabaja.setText(ejercicio.getZonaQueTrabaja());
            //TODO creo que hay un problema con el tamano de la imagen
            foto.setImageResource(ejercicio.getFoto());
            dificultad.setImageResource(ejercicio.getDificultad());
//            RequestOptions ro = new RequestOptions().placeholder(R.drawable.loading4).error(R.drawable.errornews);
//            Glide.with(context).load(unaNoticia.getUrlImagen()).apply(ro).into(imagen);
        }

    }

    public interface Comunicador2 {
        public void irAEjercicio(Ejercicio ejercicio);
    }


}
