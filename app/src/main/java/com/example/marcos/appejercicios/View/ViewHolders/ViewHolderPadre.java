package com.example.marcos.appejercicios.View.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.marcos.appejercicios.R;

/**
 * Created by main on 1/31/18.
 */

public class ViewHolderPadre extends ParentViewHolder {

    //Atributos
    public TextView textoPadre;
    public ImageButton iconoFlecha;


    //Constructor
    public ViewHolderPadre(View itemView) {
        super(itemView);

        textoPadre = itemView.findViewById(R.id.textoParent);
        iconoFlecha = itemView.findViewById(R.id.iconoFlecha);
    }
}
