package com.example.marcos.appejercicios.View.Adaptadores;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.example.marcos.appejercicios.View.Ejercicios.ContenedorEjercicios;
import com.example.marcos.appejercicios.View.Ejercicios.FragmentRecyclerEjercicios;
import com.example.marcos.appejercicios.View.Rutinas.FragmentRecyclerRutinas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 25-Jan-18.
 */

public class AdaptadorViewPagerEjs extends FragmentStatePagerAdapter {
    //Atts
    //Me guardo la lista de Categorias pata poder accederlas en el GetPageTitle del TAB
    private List<String> tiposEjercicio;
    private List<FragmentRecyclerEjercicios> listaFragments = new ArrayList<>();
    private static final String TAG = "tag";


    //Constructor
    public AdaptadorViewPagerEjs(FragmentManager fm, List<String> tiposEjercicio) {
        super(fm);
        this.tiposEjercicio = tiposEjercicio;
        for(String tipoEjercicio: tiposEjercicio){
            Log.d(TAG, "AdaptadorViewPagerEjs: ");
                listaFragments.add(FragmentRecyclerEjercicios.factory(tipoEjercicio));
        }
    }


    //Metodos
    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tiposEjercicio.get(position).toString();
    }



}
