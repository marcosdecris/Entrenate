package com.example.marcos.appejercicios.View.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.HijoExpandable;
import com.example.marcos.appejercicios.Model.PadreExpandable;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.ViewHolders.ViewHolderHijo;
import com.example.marcos.appejercicios.View.ViewHolders.ViewHolderPadre;

import java.util.List;

/**
 * Created by main on 1/31/18.
 */

public class AdaptadorExpandableRecycler extends ExpandableRecyclerAdapter<ViewHolderPadre,ViewHolderHijo> {

    LayoutInflater inflador;


    //Constructor
    public AdaptadorExpandableRecycler(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflador = LayoutInflater.from(context);
    }



    //Metodos
    @Override
    public ViewHolderPadre onCreateParentViewHolder(ViewGroup viewGroup) {

        View view = inflador.inflate(R.layout.celda_lista_parent, viewGroup, false);
        return new ViewHolderPadre(view);
    }

    @Override
    public ViewHolderHijo onCreateChildViewHolder(ViewGroup viewGroup) {

        View view = inflador.inflate(R.layout.celda_lista_hijo,viewGroup,false);
        return new ViewHolderHijo(view);
    }

    @Override
    public void onBindParentViewHolder(ViewHolderPadre viewHolderPadre, int i, Object o) {

        PadreExpandable padreExpandable = (PadreExpandable) o;
        viewHolderPadre.textoPadre.setText(padreExpandable.getTitulo());

    }

    @Override
    public void onBindChildViewHolder(ViewHolderHijo viewHolderHijo, int i, Object o) {

        Ejercicio ejercicio = (Ejercicio) o;
        viewHolderHijo.textViewNombre.setText(ejercicio.getNombre());
        viewHolderHijo.imageViewVideo.setImageResource(ejercicio.getFoto());
    }
}
