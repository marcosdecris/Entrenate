package com.example.marcos.appejercicios.View.Ejercicios;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;
import com.example.marcos.appejercicios.View.Aparatos.FragmentEjercicio;

public class ContenedorEjercicios extends AppCompatActivity implements AdaptadorEjercicios.Comunicador2{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_ejercicio);

        FragmentViewPagerEjercicio fragmentViewPagerEjercicio = new FragmentViewPagerEjercicio();
        cargarFragment(fragmentViewPagerEjercicio);

    }


    //Hago el metodo para cargar fragments
    public void cargarFragment (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contenedorEjercicios, fragment);
        transaction.commit();
    }

    //Metodo para ir a la pantalla del ejercicio (Fragment)
    @Override
    public void irAEjercicio(Ejercicio ejercicio) {
        FragmentEjercicio fragmentEjercicio = new FragmentEjercicio();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentEjercicio.CLAVE_EJERCICIO, ejercicio);
        fragmentEjercicio.setArguments(bundle);
        cargarFragment(fragmentEjercicio);
    }

}

