package com.example.reto_3.presentacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.reto_3.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ingreso_usuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ingreso_usuario extends Fragment {


    public Ingreso_usuario() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingreso_usuario, container, false);
    }
}