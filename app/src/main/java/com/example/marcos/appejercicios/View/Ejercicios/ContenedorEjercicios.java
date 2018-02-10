package com.example.marcos.appejercicios.View.Ejercicios;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;
import com.example.marcos.appejercicios.View.Aparatos.FragmentEjercicio;
import com.example.marcos.appejercicios.View.BottomNavigation.Actividades;
import com.example.marcos.appejercicios.View.BottomNavigation.Cronometro;
import com.example.marcos.appejercicios.View.BottomNavigation.Perfil;

public class ContenedorEjercicios extends AppCompatActivity implements AdaptadorEjercicios.Comunicador2 {
    //Tag
    public static final String TAG_FRAGMENT_VIEWPAGER = "Fragment viewPager";
    public static final String TAG_FRAGMENT_EJERCICIO = "Fragment ejercicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Logo en APPBAR
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.logo_appbar);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_logo);

        setContentView(R.layout.activity_contenedor_ejercicio);

        activarBottomNavigation();
        cargarFragment(new FragmentViewPagerEjercicio(), TAG_FRAGMENT_VIEWPAGER);

    }


    //Hago el metodo para cargar fragments
    public void cargarFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        //Consigo el fragment que esta en el contenedor
        Fragment fragmentContenedor = manager.findFragmentById(R.id.contenedorEjercicios);
        if (fragmentContenedor == null || fragmentContenedor.getTag() != tag) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.contenedorEjercicios, fragment, tag);
            if (fragmentContenedor != null && fragmentContenedor.getTag() != TAG_FRAGMENT_EJERCICIO) {
                //Esto me vuelve al fragment anterior
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
    }

    //Metodo para ir a la pantalla del ejercicio (Fragment)
    @Override
    public void irAEjercicio(Ejercicio ejercicio) {
        FragmentEjercicio fragmentEjercicio = new FragmentEjercicio();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentEjercicio.CLAVE_EJERCICIO, ejercicio);
        fragmentEjercicio.setArguments(bundle);
        cargarFragment(fragmentEjercicio, TAG_FRAGMENT_EJERCICIO);
    }

    public void cambiarVista(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


    public void activarBottomNavigation() {
        //Bottom Navigation, lo encuentro
        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation_ejercicio);
        //Creo los items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Inicio", R.drawable.ic_inicio);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Perfil", R.drawable.ic_usuario);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Cronometro", R.drawable.ic_cronometro);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Actividades", R.drawable.ic_calendario);

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
                switch (position) {
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
}

