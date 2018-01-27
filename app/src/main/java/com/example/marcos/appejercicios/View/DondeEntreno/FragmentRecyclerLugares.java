package com.example.marcos.appejercicios.View.DondeEntreno;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcos.appejercicios.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerLugares extends Fragment {


    public FragmentRecyclerLugares() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_recycler_lugares, container, false);
    }

}
