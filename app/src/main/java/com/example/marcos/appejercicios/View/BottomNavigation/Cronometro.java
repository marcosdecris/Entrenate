package com.example.marcos.appejercicios.View.BottomNavigation;

import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.R;

public class Cronometro extends AppCompatActivity {


    private  Button botonStart;
    private  Button botonPausa;
    private  Button botonReiniciar;
    private Chronometer cronometroActividad;
    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Logo en APPBAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_logo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_view_pager));
        setContentView(R.layout.activity_cronometro);

        botonStart = (Button) findViewById(R.id.cronometroStart);
        botonPausa = (Button) findViewById(R.id.cronometroPause);
        botonReiniciar = (Button) findViewById(R.id.cronometroReiniciar);
        cronometroActividad = (Chronometer) findViewById(R.id.cronometroActivity);

        botonStart.setEnabled(true);
        botonPausa.setEnabled(false);


        botonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastPause != 0){

                    cronometroActividad.setBase(cronometroActividad.getBase() + SystemClock.elapsedRealtime() - lastPause);
                } else{
                    cronometroActividad.setBase(SystemClock.elapsedRealtime());
                }
                cronometroActividad.start();
                botonStart.setEnabled(false);
                botonPausa.setEnabled(true);

            }
        });


        botonPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastPause = SystemClock.elapsedRealtime();
                cronometroActividad.stop();
                botonPausa.setEnabled(false);
                botonStart.setEnabled(true);

            }
        });

        botonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cronometroActividad.stop();
                cronometroActividad.setBase(SystemClock.elapsedRealtime());
                lastPause = 0;
                botonStart.setEnabled(true);
                botonPausa.setEnabled(false);


            }
        });


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
