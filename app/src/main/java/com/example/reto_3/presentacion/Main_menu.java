package com.example.reto_3.presentacion;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.reto_3.R;
import com.example.reto_3.adaptadores.ProductoAdapter;
import com.example.reto_3.casos_uso.CasoUsoProducto;
import com.example.reto_3.datos.ApiOracle;
import com.example.reto_3.datos.DBHelper;
import com.example.reto_3.modelo.Productos;

import java.util.ArrayList;


public class Main_menu extends Fragment {

    private String TABLE_NAME = "PRODUCTOS";
    private CasoUsoProducto casoUsoProducto;
    private GridView gridView;
    private ProgressBar progressBar;
    private DBHelper dbHelper;
    private ApiOracle apiOracle;
    private ArrayList<Productos> productos;

    public Main_menu() {
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
        View root = inflater.inflate(R.layout.activity_main, container, false);

        try{
            casoUsoProducto = new CasoUsoProducto();
            apiOracle = new ApiOracle(root.getContext());
            gridView = (GridView) root.findViewById(R.id.gridProductos);
            progressBar = (ProgressBar) root.findViewById(R.id.progressBarProd);
            apiOracle.getAllProductos(gridView, progressBar);


            //dbHelper = new DBHelper(getContext());
            //Cursor cursor = dbHelper.getData(TABLE_NAME);
            //productos = casoUsoProducto.llenarListaProductos(cursor);

            //ProductoAdapter productoAdapter = new ProductoAdapter(root.getContext(), productos);
            //gridView.setAdapter(productoAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        return root;


    }
}