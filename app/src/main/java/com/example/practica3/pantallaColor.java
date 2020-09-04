package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class pantallaColor extends AppCompatActivity {

    private Button btAzul;
    private Button btRosa;
    private Button btMorado;
    private ConstraintLayout fondo;
    private String color = "nada";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.entrada2, R.anim.salida2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_color);

        //referenciar
        btAzul = findViewById(R.id.btAzul);
        btRosa = findViewById(R.id.btRosa);
        btMorado = findViewById(R.id.btMorado);
        fondo = findViewById(R.id.fondo);

        SharedPreferences fondos1 = getSharedPreferences("colores", MODE_PRIVATE);
        color = fondos1.getString("color","no_fondo");

        if(color.equals("rosa")){
            fondo.setBackgroundColor((Color.rgb(243,167,230)));
        }
        if(color.equals("azul")){
            fondo.setBackgroundColor((Color.rgb(139,214,223)));
        }
        if(color.equals("morado")){
            fondo.setBackgroundColor((Color.rgb(168,144,227)));
        }
        btAzul.setOnClickListener(
                (view) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "azul");
                    setResult(RESULT_OK, i);
                    finish();
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                }
        );

        btRosa.setOnClickListener(
                (view) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "rosa");
                    setResult(RESULT_OK, i);
                    finish();
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);


                }
        );

        btMorado.setOnClickListener(
                (view) -> {
                    Intent i = new Intent();
                    i.putExtra("color", "morado");
                    setResult(RESULT_OK, i);
                    finish();
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);



                }
        );


    }
}