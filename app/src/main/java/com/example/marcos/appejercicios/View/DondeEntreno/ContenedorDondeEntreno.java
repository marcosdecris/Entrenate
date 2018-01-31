package com.example.marcos.appejercicios.View.DondeEntreno;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorDndeEntreno;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class ContenedorDondeEntreno extends AppCompatActivity implements AdaptadorDndeEntreno.Comunicador3{
    //Esto es del maps, probar conexion
    private static final String TAG = "Contenedor";
    private static final int ERROR_DIALOG_REQUEST  = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_donde_entreno);

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
    public void irAMapa() {
        if(isServicesOk()){
            // TODO -- Escribir el metodo que va al mapa
//            FragmentDetalleLugar fragmentDetalleLugar = new FragmentDetalleLugar();
//            cargarFragment(fragmentDetalleLugar);
            Intent intent = new Intent(ContenedorDondeEntreno.this, MapActivity.class);
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

}
