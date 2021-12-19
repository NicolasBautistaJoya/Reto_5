package com.example.reto_3.presentacion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reto_3.R;

public class SplashScreen  extends AppCompatActivity implements Runnable {

    Thread h1;

    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar.incrementProgressBy(20);
            }
        };
        for (int i=0; i<5; i++){
            new Handler().postDelayed(runnable, (i+1)*1000);
        }

        ImageView marca = (ImageView)findViewById(R.id.marca);

        h1= new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}