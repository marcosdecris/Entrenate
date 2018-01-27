package com.example.marcos.appejercicios.View.Adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import com.example.marcos.appejercicios.View.Rutinas.FragmentRecyclerRutinas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 26-Jan-18.
 */

public class AdaptadorViewPagerRutns extends FragmentStatePagerAdapter {
    //Atts
    //Me guardo la lista de Categorias pata poder accederlas en el GetPageTitle del TAB
    private List<String> tiposRutinas;
    private List<FragmentRecyclerRutinas> listaFragments = new ArrayList<>();


    public AdaptadorViewPagerRutns(FragmentManager fm, List<String> tiposRutinas) {
        super(fm);
        this.tiposRutinas = tiposRutinas;
        for(String tipoRutina: tiposRutinas){
            listaFragments.add(FragmentRecyclerRutinas.factory(tipoRutina));

        }

    }

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
        return tiposRutinas.get(position).toString();
    }
}
