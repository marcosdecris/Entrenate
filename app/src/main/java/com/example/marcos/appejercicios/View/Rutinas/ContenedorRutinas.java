package com.example.marcos.appejercicios.View.Rutinas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.Model.Rutina;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorRecycRutinas;
import com.example.marcos.appejercicios.View.Aparatos.FragmentEjercicio;
import com.example.marcos.appejercicios.View.BottomNavigation.Actividades;
import com.example.marcos.appejercicios.View.BottomNavigation.Cronometro;
import com.example.marcos.appejercicios.View.BottomNavigation.Perfil;
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

        activarBottomNavigation();

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
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_CALENTAMIENTO, (ArrayList<Integer>) listaEjsCal);
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_RUTINA, (ArrayList<Integer>) listaEjercicios);
        bundle.putIntegerArrayList(fragmentDetalleRutina.CLAVE_DETALLE_ESTIRAMIENTO, (ArrayList<Integer>) listaEjsEsti);
        fragmentDetalleRutina.setArguments(bundle);
        cargarFragment(fragmentDetalleRutina, CLAVE_DETALLE_RUTINA);
    }

    @Override
    public void comenzarRutina(List<Integer> listaIdsEjsCal, List<Integer> listaIdsEjsRtna, List<Integer> listaIdsEjsEsti) {
        FragmentEjercicioRutina fragmentEjercicioRutina = new FragmentEjercicioRutina();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList(fragmentEjercicioRutina.CLAVE_DETALLE_CALENTAMIENTO, (ArrayList<Integer>) listaIdsEjsCal);
        bundle.putIntegerArrayList(fragmentEjercicioRutina.CLAVE_DETALLE_RUTINA, (ArrayList<Integer>) listaIdsEjsRtna);
        bundle.putIntegerArrayList(fragmentEjercicioRutina.CLAVE_DETALLE_ESTIRAMIENTO, (ArrayList<Integer>) listaIdsEjsEsti);
        fragmentEjercicioRutina.setArguments(bundle);
        cargarFragment(fragmentEjercicioRutina, CLAVE_EJERCICIO_RUTINA);
    }

    public void cambiarVista( Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


    public void activarBottomNavigation(){
        //Bottom Navigation, lo encuentro
        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation_rutinas);
        //Creo los items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Inicio",R.drawable.ic_inicio );
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Perfil",R.drawable.ic_usuario );
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Cronometro",R.drawable.ic_cronometro );
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Actividades",R.drawable.ic_calendario );

        //Cargo el Bottom Navigation
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

        //Elijo que item va a mostrar primero por default
        bottomNavigation.setCurrentItem(0);
        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#494949"));
        //Color del item actual
        bottomNavigation.setAccentColor(Color.parseColor("#ffffff"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(true);
        //Para que se muestre siempre el texto abajo de los iconos
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);


        //Seteo el Listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position){
                    case 0:
                        cambiarVista(MainActivity.class);
                        break;
                    case 1:
                        cambiarVista(Perfil.class);
                        break;
                    case 2:
                        cambiarVista(Cronometro.class);
                        break;
                    case 3:
                        cambiarVista(Actividades.class);
                        break;
                }
                return true;
            }
        });

    }
    //Metodo para comenzar la rutina

}
