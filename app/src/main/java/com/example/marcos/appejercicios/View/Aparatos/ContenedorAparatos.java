package com.example.marcos.appejercicios.View.Aparatos;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.MainActivity;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorGrid;
import com.example.marcos.appejercicios.View.BottomNavigation.Actividades;
import com.example.marcos.appejercicios.View.BottomNavigation.Cronometro;
import com.example.marcos.appejercicios.View.BottomNavigation.Perfil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContenedorAparatos extends AppCompatActivity implements AdaptadorGrid.Comunicador, AdaptadorEjercicios.Comunicador2{
    //Tag
    public static final String TAG_FRAGMENT_RECY_APAR = "Fragment recycApar";
    public static final String TAG_FRAGMENT_GRID = "Fragment grid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_aparatos);

       activarBottomNavigation();

       FragmentGridViewAparatos fragmentGridViewAparatos = new FragmentGridViewAparatos();
       cargarFragment(fragmentGridViewAparatos, TAG_FRAGMENT_GRID);
    }


    //Hago el metodo para cargar fragments
    public void cargarFragment (Fragment fragment, String tag){
        FragmentManager manager = getSupportFragmentManager();
        // Consigo el fragment que esta actualmente en el contenedor, puede ser null
        Fragment fragmentContenedor = manager.findFragmentById(R.id.contenedorFragmentsAparatos);
        //Si esta vacio o es diferente al que esta en el contenedor
        if(fragmentContenedor == null || fragmentContenedor.getTag() != tag ){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.contenedorFragmentsAparatos, fragment);
            //TODO -- chequear que no falta data en el if
            if(fragmentContenedor != null ){
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }


    }

    //Metodo de la interface del Adaptador del Grid para ir al RecyclerEjs o al Ejercicio
    @Override
    public void irARecycler(List<Integer> listaIdEjercicios) {
        if(listaIdEjercicios.size() > 1){
            FragmentRecyclerEjsAparatos fragmentRecyclerEjsAparatos = new FragmentRecyclerEjsAparatos();
            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList(FragmentRecyclerEjsAparatos.CLAVE_LISTAEJS, (ArrayList<Integer>) listaIdEjercicios);
            fragmentRecyclerEjsAparatos.setArguments(bundle);
            cargarFragment(fragmentRecyclerEjsAparatos, TAG_FRAGMENT_GRID);
        }else{
            DaoEjercicio daoEjercicio = new DaoEjercicio();
            Integer id = listaIdEjercicios.get(0);
            Ejercicio ejercicio = daoEjercicio.buscarEjPorId(id);
            irAEjercicio(ejercicio);
        }

    }

    //Metodo para ir a la pantalla del ejercicio (Fragment) -- Este metodo lo comparten los dos Contenedores (Aparatos - Ejs)
    @Override
    public void irAEjercicio(Ejercicio ejercicio) {
        FragmentEjercicio fragmentEjercicio = new FragmentEjercicio();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentEjercicio.CLAVE_EJERCICIO, ejercicio);
        fragmentEjercicio.setArguments(bundle);
        cargarFragment(fragmentEjercicio, TAG_FRAGMENT_RECY_APAR);
    }

    public void cambiarVista( Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }


    public void activarBottomNavigation(){
        //Bottom Navigation, lo encuentro
        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation_aparatos);
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


        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#e9f9e941"));
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
}
