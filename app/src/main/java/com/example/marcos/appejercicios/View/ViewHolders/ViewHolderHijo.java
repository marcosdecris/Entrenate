package com.example.marcos.appejercicios.View.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;

/**
 * Created by main on 1/31/18.
 */

public class ViewHolderHijo extends ChildViewHolder{

    //Atributos
    public TextView textViewNombre;
    public ImageView imageViewVideo;



    //Constructor
    public ViewHolderHijo(View itemView) {
        super(itemView);

        textViewNombre = itemView.findViewById(R.id.textoCeldaHijo);
        imageViewVideo = itemView.findViewById(R.id.fotoCeldaHijo);

    }
}
