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
import com.example.marcos.appejercicios.View.DondeEntreno.ContenedorDondeEntreno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContenedorRutinas extends AppCompatActivity implements AdaptadorRecycRutinas.ComunicadorRutinas, FragmentDetalleRutina.EmpezarRtna{
    //Tags
    private static final String CLAVE_VIEWPAGER_RUTINAS = "Viewpager rutinas";
    private static final String CLAVE_DETALLE_RUTINA = "Detalle rutina";
    private static final String CLAVE_EJERCICIO_RUTINA = "Ejercicio rutina";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_rutinas);

        FragmentViewPagerRutina fragmentViewPagerRutina = new FragmentViewPagerRutina();
        cargarFragment(fragmentViewPagerRutina, CLAVE_VIEWPAGER_RUTINAS);

    }

    //Hago el metodo para cargar fragments
    public void cargarFragment (Fragment fragment, String tag){
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragmentContenedor = manager.findFragmentById(R.id.contenedorRutinas);
        if(fragmentContenedor == null || fragmentContenedor.getTag() != tag){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.contenedorRutinas, fragment);
            if(fragmentContenedor != null){
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }


    }
    //Metodo para ir al detalle de la rutina
    @Override
    public void irADetalle(List<Integer> listaEjsCal, List<Integer> listaEjercicios, List<Integer> listaEjsEsti) {
        FragmentDetalleRutina fragmentDetalleRutina = new FragmentDetalleRutina();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_ESTIRAMIENTO, (ArrayList<Integer>) listaEjsCal);
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_RUTINA, (ArrayList<Integer>) listaEjercicios);
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_CALENTAMIENTO, (ArrayList<Integer>) listaEjsEsti);
        fragmentDetalleRutina.setArguments(bundle);
        cargarFragment(fragmentDetalleRutina, CLAVE_DETALLE_RUTINA);
    }

    @Override
    public void comenzarRutina(List<Integer> listaIdsEjsCal, List<Integer> listaIdsEjsRtna, List<Integer> listaIdsEjsEsti) {
        FragmentEjercicioRutina fragmentEjercicioRutina = new FragmentEjercicioRutina();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList(fragmentEjercicioRutina.CLAVE_DETALLE_ESTIRAMIENTO, (ArrayList<Integer>) listaIdsEjsCal);
        bundle.putIntegerArrayList(fragmentEjercicioRutina.CLAVE_DETALLE_RUTINA, (ArrayList<Integer>) listaIdsEjsRtna);
        bundle.putIntegerArrayList(fragmentEjercicioRutina.CLAVE_DETALLE_CALENTAMIENTO, (ArrayList<Integer>) listaIdsEjsEsti);
        fragmentEjercicioRutina.setArguments(bundle);
        cargarFragment(fragmentEjercicioRutina, CLAVE_EJERCICIO_RUTINA);
    }


    //Metodo para comenzar la rutina

}
