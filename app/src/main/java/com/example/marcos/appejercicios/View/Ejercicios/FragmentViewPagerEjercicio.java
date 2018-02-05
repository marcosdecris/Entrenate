package com.example.marcos.appejercicios.View.Ejercicios;


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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPagerEjercicio extends Fragment {
    //Atts
    private List<String> tiposEj = new ArrayList<>();

    public FragmentViewPagerEjercicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cargarLista();
        // Inflate the layout for this fragment or reuse the existing one
        View view =  inflater.inflate(R.layout.fragment_fragment_view_pager, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPagerEjercicios);

        //Le paso al adaptador del ViewPager la lista de Strings de tipo de Ejercicios
        AdaptadorViewPagerEjs adaptadorViewPagerEjs = new AdaptadorViewPagerEjs(getChildFragmentManager(), tiposEj);
        viewPager.setAdapter(adaptadorViewPagerEjs);
        TabLayout tabLayout = view.findViewById(R.id.tabLayoutEjercicios);
        tabLayout.setupWithViewPager(viewPager);
        Toast.makeText(getContext(), "OnCreate", Toast.LENGTH_SHORT).show();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG).show();
    }

    //TODO -- Revisar que los tipos de ej no esten hardcodeados, fijarse en Enterate
    public void cargarLista(){
        tiposEj.add("aerobico");
        tiposEj.add("funcional");
        tiposEj.add("musculacion");
    }

}
