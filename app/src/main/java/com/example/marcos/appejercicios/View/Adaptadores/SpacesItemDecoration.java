package com.example.marcos.appejercicios.View.Adaptadores;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Marcos on 06-Feb-18.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int mSpace;

    //Esta clase es para setear el espacio entre los items del Recycler con Grid de Aparatos

    //Constructor
    public SpacesItemDecoration(int space) {
        this.mSpace = space;
    }

    //Metodo
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = mSpace;
    }

}
