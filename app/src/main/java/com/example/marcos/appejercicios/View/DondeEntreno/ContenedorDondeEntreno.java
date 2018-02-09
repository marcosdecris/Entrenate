package com.example.marcos.appejercicios.View.DondeEntreno;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorDndeEntreno;
import com.example.marcos.appejercicios.View.BottomNavigation.Actividades;
import com.example.marcos.appejercicios.View.BottomNavigation.Cronometro;
import com.example.marcos.appejercicios.View.BottomNavigation.Perfil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class ContenedorDondeEntreno extends AppCompatActivity implements AdaptadorDndeEntreno.Comunicador3{
    //Esto es del maps, probar conexion
    private static final String TAG = "Contenedor";
    private static final int ERROR_DIALOG_REQUEST  = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Logo en APPBAR
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_appbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        setContentView(R.layout.activity_contenedor_donde_entreno);

        activarBottomNavigation();
        FragmentRecyclerLugares fragmentRecyclerLugares = new FragmentRecyclerLugares();
        cargarFragment(fragmentRecyclerLugares);
    }


    //Hago el metodo para cargar fragments
    public void cargarFragment (Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contenedorDndeEntr, fragment);
        transaction.commit();
    }


    //Metodo que viene del onClic del adaptador
    @Override
    public void irAMapa(String nombre, String direccion) {
        if(isServicesOk()){
            // TODO -- Escribir el metodo que va al mapa
//            FragmentDetalleLugar fragmentDetalleLugar = new FragmentDetalleLugar();
//            cargarFragment(fragmentDetalleLugar);
            Intent intent = new Intent(ContenedorDondeEntreno.this, MapActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(MapActivity.CLAVE_NOMBRE, nombre);
            bundle.putString(MapActivity.CLAVE_DIRECCION, direccion);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }



    //Metodo para ver si el telefono tiene la actualizacion de google services
    public boolean isServicesOk(){
        Log.d(TAG, "isServicesOk: Checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ContenedorDondeEntreno.this);

        if(available == ConnectionResult.SUCCESS){
            //Si funciona
            Log.d(TAG, "isServicesOk: Google services is working");
            return true;
        }//Si hay un error pero se puede solucionar
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServicesOk: An error ocurred but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(ContenedorDondeEntreno.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "No se pueden solicitar mapas, actualizar Google Play Services", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void cambiarVista(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


    public void activarBottomNavigation() {
        //Bottom Navigation, lo encuentro
        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation_dondeEntreno);
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
