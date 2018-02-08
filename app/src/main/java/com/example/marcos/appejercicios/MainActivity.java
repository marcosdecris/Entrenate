package com.example.marcos.appejercicios;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.View.Aparatos.ContenedorAparatos;
import com.example.marcos.appejercicios.View.BottomNavigation.Actividades;
import com.example.marcos.appejercicios.View.BottomNavigation.Cronometro;
import com.example.marcos.appejercicios.View.BottomNavigation.Perfil;
import com.example.marcos.appejercicios.View.DondeEntreno.ContenedorDondeEntreno;
import com.example.marcos.appejercicios.View.Ejercicios.ContenedorEjercicios;
import com.example.marcos.appejercicios.View.Rutinas.ContenedorRutinas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_entrenate);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);


        ImageView aparatos = (ImageView) findViewById(R.id.imageViewMainAparatos);
        ImageView rutinas = (ImageView) findViewById(R.id.imageViewMainRutinas);
        ImageView ejercicios = (ImageView) findViewById(R.id.imageViewMainEjercicios);
        ImageView dondeEntreno = (ImageView) findViewById(R.id.imageViewMainDondeEntreno);

        activarBottomNavigation();

        //Listeners para las views
        aparatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarVista(ContenedorAparatos.class);
            }
        });

        rutinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarVista(ContenedorRutinas.class);
            }
        });

        ejercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarVista(ContenedorEjercicios.class);
            }
        });

        dondeEntreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarVista(ContenedorDondeEntreno.class);
            }
        });




    }

    public void cambiarVista( Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


    public void activarBottomNavigation(){
        //Bottom Navigation, lo encuentro
        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);
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
        bottomNavigation.setBehaviorTranslationEnabled(false);
        //Para que se muestre siempre el texto abajo de los iconos
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);


        //Seteo el Listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position){
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
