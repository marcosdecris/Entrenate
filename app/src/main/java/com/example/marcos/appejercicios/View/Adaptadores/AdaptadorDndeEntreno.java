package com.example.marcos.appejercicios.View.Adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marcos.appejercicios.Model.Plaza;
import com.example.marcos.appejercicios.R;

import java.util.List;

/**
 * Created by Marcos on 31-Jan-18.
 */

public class AdaptadorDndeEntreno extends RecyclerView.Adapter<AdaptadorDndeEntreno.MyRecyclerViewHolder> {
    //Atts
    private List<Plaza> listaPlazas;
    private Context context;
    private Comunicador3 comunicador3;

    //Constructor
    public AdaptadorDndeEntreno(Context context, List<Plaza> listaPlazas) {
        this.listaPlazas = listaPlazas;
        this.context = context;
        this.comunicador3 = (Comunicador3) context;
    }

    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creo el inflados
        LayoutInflater inflador = LayoutInflater.from(context);
        //inflo la vista
        View view = inflador.inflate(R.layout.celda_donde_entreno, parent, false);
        //Instancio el viewholder
        MyRecyclerViewHolder holder = new MyRecyclerViewHolder(view);
        //Devuelvo la vista
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewHolder holder, int position) {
        final Plaza plaza = listaPlazas.get(position);
        holder.bindCelda(plaza);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO -- Metodo para ir a detalle
               comunicador3.irAMapa(plaza.getDireccion());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPlazas.size();
    }

    //Creo la clase viewholder
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        //Atts viewholder
        private TextView nombre;
        private LinearLayout layout;


        //Constructror viewholder
        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.textViewNombreDndeEntr);
            layout = itemView.findViewById(R.id.layoutCeldaDndEntreno);
        }

        //Metodos viewholder
        public void bindCelda (Plaza plaza){
            nombre.setText(plaza.getNombre());

        }

    }

    public interface Comunicador3 {
        public void irAMapa(String direccion );
    }
}
