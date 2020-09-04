package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class pantallaFinal extends AppCompatActivity {

    private Button btReinicio;
    private TextView txHola, txNota;
    private ConstraintLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        btReinicio = findViewById(R.id.btReinicio);
        txHola = findViewById(R.id.txHola);
        txNota = findViewById(R.id.txNota);
        fondo = findViewById(R.id.fondo);

        SharedPreferences fondos = getSharedPreferences("colores", MODE_PRIVATE);
        String color = fondos.getString("color","no_fondo");

        if(color.equals("rosa")){
            fondo.setBackgroundColor((Color.rgb(243,167,230)));
        }
        if(color.equals("azul")){
            fondo.setBackgroundColor((Color.rgb(139,214,223)));
        }
        if(color.equals("morado")){
            fondo.setBackgroundColor((Color.rgb(168,144,227)));
        }


        //para reducir el numero de decimales que aparecen
        Double notaFinal = getIntent().getExtras().getDouble("nota final");
        DecimalFormat formato1 = new DecimalFormat("#.00");
        txNota.setText(""+formato1.format(notaFinal));

        //shared preferences
        SharedPreferences preferences = getSharedPreferences("nombre",MODE_PRIVATE);
        String nom = preferences.getString("nom","no_user");

        txHola.setText("Hola, "+nom+"! Tu nota final es de..");


        btReinicio.setOnClickListener(
                (view) -> {
                    //paso a la pantalla final
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                }
        );

    }
}