package com.example.marcos.appejercicios.View.Rutinas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marcos.appejercicios.R;

public class ContenedorRutinas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_rutinas);

        FragmentViewPagerRutina fragmentViewPagerRutina = new FragmentViewPagerRutina();
        cargarFragment(fragmentViewPagerRutina);

    }

    //Hago el metodo para cargar fragments
    public void cargarFragment (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contenedorRutinas, fragment);
        transaction.commit();
    }
}
