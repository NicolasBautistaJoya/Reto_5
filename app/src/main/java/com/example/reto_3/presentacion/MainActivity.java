package com.example.reto_3.presentacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.reto_3.R;

//Main Activity
/* Main Activity */
/** Main Activity **/
public class MainActivity extends AppCompatActivity {

    //Declaracion nombre de la tabla
    /* Declaracion nombre de la tabla */
    /** Declaracion nombre de la tabla **/
    private String TABLE_NAME = "PRODUCTOS";

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment menuHamb;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment menuPizza;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment menuHotdog;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment menuEmpanada;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment ingresoUsuario;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment buscar;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment favorito;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment mainMenu;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment servicios;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment sucursales;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment agregar;

    //Declaracion fragments
    /* Declaracion fragments */
    /** Declaracion fragments **/
    Fragment perfil;

    //Declaracion transaccion
    /* Declaracion transaccion */
    /** Declaracion transaccion **/
    FragmentTransaction intercambio;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button botonComp;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button botonComp2;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button botonComp3;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button botonComp4;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button backHamb;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button backEmp;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button backHot;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button backPi;

    //Declaracion botones
    /* Declaracion botones */
    /** Declaracion botones **/
    Button ingresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Asignacion fragments
        /* Asignacion fragments */
        /** Asignacion fragments **/
        ingresoUsuario = new Ingreso_usuario();
        buscar = new Buscar();
        favorito = new Favoritos();
        servicios = new Servicios();
        sucursales = new Sucursales();
        agregar = new Form_menu();
        mainMenu = new Main_menu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Controlador items
    /* Controlador items */
    /** Controlador items **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.usuario:
                getSupportFragmentManager().beginTransaction().replace(R.id.menu, ingresoUsuario).commit();
                return true;
            case R.id.buscar:
                getSupportFragmentManager().beginTransaction().replace(R.id.menu, buscar).commit();
                return true;
            case R.id.favorito:
                getSupportFragmentManager().beginTransaction().replace(R.id.menu, favorito).commit();
                return true;
            case R.id.productos:
                getSupportFragmentManager().beginTransaction().replace(R.id.menu, mainMenu).commit();
                return true;
            case R.id.servicios:
                getSupportFragmentManager().beginTransaction().replace(R.id.menu, servicios).commit();
                return true;
            case R.id.sucursales:
                getSupportFragmentManager().beginTransaction().replace(R.id.menu, sucursales).commit();
                return true;
            case R.id.agregar:
                Intent intent = new Intent(this, FormActivity.class);
                intent.putExtra("name", "PRODUCTOS");
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }

}