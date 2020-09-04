package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class pantallaColor extends AppCompatActivity {

    private Button btAzul;
    private Button btRosa;
    private Button btMorado;
    private ConstraintLayout fondo;
    private String color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_color);

        //referenciar
        btAzul = findViewById(R.id.btAzul);
        btRosa = findViewById(R.id.btRosa);
        btMorado = findViewById(R.id.btMorado);
        fondo = findViewById(R.id.fondo);


        btAzul.setOnClickListener(
                (view) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "azul");
                    setResult(RESULT_OK, i);
                    finish();

                }
        );

        btRosa.setOnClickListener(
                (view) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "rosa");
                    setResult(RESULT_OK, i);
                    finish();


                }
        );

        btMorado.setOnClickListener(
                (view) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "morado");
                    setResult(RESULT_OK, i);
                    finish();



                }
        );


    }
}