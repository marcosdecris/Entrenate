package com.example.marcos.appejercicios.View.Adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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


    //Constructor
    public AdaptadorViewPagerEjs(FragmentManager fm, List<String> tiposEjercicio) {
        super(fm);
        this.tiposEjercicio = tiposEjercicio;
        for(String tipoEjercicio: tiposEjercicio){
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
