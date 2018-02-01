package com.example.marcos.appejercicios.View.DondeEntreno;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcos.appejercicios.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {
    //Constantes
    private static final String TAG = "MapActivity";
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final String CLAVE_NOMBRE= "Nombre";
    public static final String CLAVE_DIRECCION = "Direccion";
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 12334;
    private static final float DEFAULT_ZOOM = 15f;
    private static final LatLngBounds LAT_LNG_BOUNDS = new LatLngBounds(new LatLng(-40, -168), new LatLng(71, 136));

    //vars
    private Boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mfusedLocationProviderClient;
    private GeoDataClient mGeoDataClient;
    private String nombrePlaza;
    private String ubicacionPlaza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nombrePlaza = bundle.getString(CLAVE_NOMBRE);
        ubicacionPlaza = bundle.getString(CLAVE_DIRECCION);
        getLocationPermisiion();
        TextView textView = findViewById(R.id.textViewMapNombre);
        textView.setText(nombrePlaza);
    }

    //Inicializo el mapa
    //Metodo para iniciar el mapa
    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Toast.makeText(MapActivity.this, "Map Is ready", Toast.LENGTH_SHORT).show();
                mMap = googleMap;

                if (mLocationPermissionGranted) {
                    geolocate();
                   // getDeviceLocation();
                    //Chequear si no funciona el Coarse permission en esta linea
                    if (ActivityCompat.checkSelfPermission(MapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    //Estas opciones son las que elegis que te muestre el mapa. Se pueden investigar otras
                    //Tu location
                    mMap.setMyLocationEnabled(true);
                    //Que muestre el boton de ir a tu ubicacion
                    mMap.getUiSettings().setMyLocationButtonEnabled(true);



                }
            }
        });
    }

    //Metodo para encontrar la ubicacion del celular
    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting the devices current location");
        mfusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (mLocationPermissionGranted) {
                //TODO ver si aca se puede cambiar el metodo del fusedLocationprovider para pedirle una ubicacion especifica
                Task<Location> location = mfusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "onComplete: found location!");
                            Location currentLocation = task.getResult();

                            moveCamara(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM, "Mi ubicacion");

                        } else {
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapActivity.this, "Unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        } catch (SecurityException e) {
            Log.d(TAG, "getDeviceLocation: SecurityException " + e.getMessage());
        }
    }

    //Metodo para encontrar una direccion en google maps
    public void geolocate(){
        Log.d(TAG, "geolocate: geolocating");

        Geocoder geocoder = new Geocoder(MapActivity.this);

        List<Address> listaAdress = new ArrayList<>();
        try {
            listaAdress = geocoder.getFromLocationName(ubicacionPlaza, 1);
        }catch (IOException e){
            Log.d(TAG, "geolocate: IOException " + e.getMessage());
        }
        if(listaAdress.size() > 0 ){
            Address address = listaAdress.get(0);
            Log.d(TAG, "geolocate: found a location" + address.toString());

            moveCamara(new LatLng(address.getLatitude(), address.getLongitude()), DEFAULT_ZOOM, nombrePlaza);
        }

    }

    //Metodo para mover la camara del mapa a un punto
    private void moveCamara(LatLng latlng, float zoom, String nombreMarcador) {
        Log.d(TAG, "moveCamara: moving camara to: lat " + latlng.latitude + ", long " + latlng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoom));

        //Este if es para que no me marque el punto donde estoy yo(con marcador rojo), si lo quiero le saco el if y si me lo marca
        if(!nombreMarcador.equals("My location")){
            MarkerOptions options = new MarkerOptions().position(latlng).title(nombreMarcador);
            mMap.addMarker(options);
        }


    }




    //Estos dos metodos son para obtener y chequear que tenemos los permisos
    private void getLocationPermisiion(){
        String[] permissions ={Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mLocationPermissionGranted = true;
            initMap();
        }else{
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i<grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }
}
