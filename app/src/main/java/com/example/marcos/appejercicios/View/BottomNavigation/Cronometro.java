package com.example.marcos.appejercicios.View.BottomNavigation;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.R;

public class Cronometro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        activarBottomNavigation();
    }

    public void cambiarVista( Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


    public void activarBottomNavigation(){
        //Bottom Navigation, lo encuentro
        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation_cronometro);
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
        bottomNavigation.setCurrentItem(2);
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
                    case 0:
                        cambiarVista(MainActivity.class);
                        break;
                    case 1:
                        cambiarVista(Perfil.class);
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
