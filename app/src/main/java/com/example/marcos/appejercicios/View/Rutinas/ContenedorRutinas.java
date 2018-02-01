package com.example.marcos.appejercicios.View.Rutinas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.Rutina;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorRecycRutinas;
import com.example.marcos.appejercicios.View.Aparatos.FragmentEjercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContenedorRutinas extends AppCompatActivity implements AdaptadorRecycRutinas.ComunicadorRutinas{

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

    @Override
    public void irADetalle(List<Integer> listaEjercicios) {
        FragmentDetalleRutina fragmentDetalleRutina = new FragmentDetalleRutina();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_RUTINA, (ArrayList<Integer>) listaEjercicios);
        fragmentDetalleRutina.setArguments(bundle);
        cargarFragment(fragmentDetalleRutina);
    }


    //Metodo para ir a la pantalla con el detalle de la rutina (Fragment)

}