package com.example.marcos.appejercicios.View.Adaptadores;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcos.appejercicios.Model.Aparato;
import com.example.marcos.appejercicios.R;

import java.util.List;

/**
 * Created by Marcos on 23-Jan-18.
 */

public class AdaptadorGrid extends RecyclerView.Adapter<AdaptadorGrid.MyRecyclerViewHolder> {
    //Atts
    private Context context;
    private List<Aparato> listaAparatos;
    private Comunicador comunicador;

    //Constructor
    public AdaptadorGrid(Context context, List<Aparato> listaAparatos) {
        this.context = context;
        this.listaAparatos = listaAparatos;
        this.comunicador = (Comunicador) context;
    }

    @Override
    public AdaptadorGrid.MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creo el inflados
        LayoutInflater inflador = LayoutInflater.from(context);
        //inflo la vista
        View view = inflador.inflate(R.layout.celda_grid_aparatos, parent, false);
        //Instancio el viewholder
        AdaptadorGrid.MyRecyclerViewHolder holder = new AdaptadorGrid.MyRecyclerViewHolder(view);
        //Devuelvo la vista
        return holder;

    }

    @Override
    public void onBindViewHolder(AdaptadorGrid.MyRecyclerViewHolder holder, int position) {
        final Aparato aparato = listaAparatos.get(position);
        holder.bindCelda(aparato);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO -- Metodo para ir al Recycler aparatos
                comunicador.irARecycler(aparato.getListaEjercicios());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaAparatos.size();
    }


    //Creo la clase viewholder
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        //Atts viewholder
        private TextView nombre;
        private TextView zonaTrabaja;
        private ImageView foto;
        private ImageView dificultad;
        private CardView layout;


        //Constructror viewholder
        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewGridNombre);
            zonaTrabaja = itemView.findViewById(R.id.textViewGridZonaTrabaja);
            foto = itemView.findViewById(R.id.imageViewImagenGrid);
            dificultad = itemView.findViewById(R.id.imageViewGridDificultad);
            layout = itemView.findViewById(R.id.layoutGridAparatos);
        }

        //Metodos viewholder
        public void bindCelda (Aparato aparato){
            nombre.setText(aparato.getNombre());
            zonaTrabaja.setText(aparato.getZonaQueTrabaja());
            foto.setImageResource(aparato.getFoto());
            dificultad.setImageResource(aparato.getDificultad());
//            RequestOptions ro = new RequestOptions().placeholder(R.drawable.loading4).error(R.drawable.errornews);
//            Glide.with(context).load(unaNoticia.getUrlImagen()).apply(ro).into(imagen);
        }

    }

    //Interface del listener del Grid
    public interface Comunicador {
        public void irARecycler(List<Integer> listaEjercicios);
    }
}
