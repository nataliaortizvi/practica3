package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class pantallaColor extends AppCompatActivity {

    private Button btAzul;
    private Button btRosa;
    private Button btMorado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_color);

        //referenciar
        btAzul = findViewById(R.id.btAzul);
        btRosa = findViewById(R.id.btRosa);
        btMorado = findViewById(R.id.btMorado);

    }
}