package com.example.marcos.appejercicios.View.Aparatos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marcos.appejercicios.DAO.DaoEjercicio;
import com.example.marcos.appejercicios.Model.Ejercicio;
import com.example.marcos.appejercicios.R;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorEjercicios;
import com.example.marcos.appejercicios.View.Adaptadores.AdaptadorGrid;

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
}
