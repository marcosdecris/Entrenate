package com.example.marcos.appejercicios.View.Rutinas;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorViewPagerEjs;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorViewPagerRutns;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPagerRutina extends Fragment {
    //Atts
    private List<String> tipoRutina = new ArrayList<>();

    //Constructor
    public FragmentViewPagerRutina() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(tipoRutina.size() == 0 ){
            cargarTiposRutina();
        }

        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_fragment_view_pager_rutina, container, false);
      ViewPager viewPagerRutina = view.findViewById(R.id.viewPagerRutinas);
      AdaptadorViewPagerRutns adaptadorViewPagerRutns = new AdaptadorViewPagerRutns(getChildFragmentManager(), tipoRutina);

        viewPagerRutina.setAdapter(adaptadorViewPagerRutns);
        TabLayout tabLayout = view.findViewById(R.id.tabLayoutRutinas);
        tabLayout.setupWithViewPager(viewPagerRutina);


        return view;
    }

    public void cargarTiposRutina(){
        tipoRutina.add("Aerobico");
        tipoRutina.add("Funcional");
        tipoRutina.add("Musculacion");
    }

}
