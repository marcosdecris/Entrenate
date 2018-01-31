package com.example.marcos.appejercicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.View.Aparatos.ContenedorAparatos;
import com.example.marcos.appejercicios.View.DondeEntreno.ContenedorDondeEntreno;
import com.example.marcos.appejercicios.View.Ejercicios.ContenedorEjercicios;
import com.example.marcos.appejercicios.View.Rutinas.ContenedorRutinas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView aparatos = (ImageView) findViewById(R.id.imageViewMainAparatos);
        ImageView rutinas = (ImageView) findViewById(R.id.imageViewMainRutinas);
        ImageView ejercicios = (ImageView) findViewById(R.id.imageViewMainEjercicios);
        ImageView dondeEntreno = (ImageView) findViewById(R.id.imageViewMainDondeEntreno);



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


}
