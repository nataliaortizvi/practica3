package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class pantallaFinal extends AppCompatActivity {

    private Button btReinicio;
    private TextView txHola, txNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        btReinicio = findViewById(R.id.btReinicio);
        txHola = findViewById(R.id.txHola);
        txNota = findViewById(R.id.txNota);

        //para reducir el numero de decimales que aparecen
        Double notaFinal = getIntent().getExtras().getDouble("nota final");
        DecimalFormat formato1 = new DecimalFormat("#.00");
        txNota.setText(""+formato1.format(notaFinal));

        //shared preferences
        SharedPreferences preferences = getSharedPreferences("nombre",MODE_PRIVATE);
        String nom = preferences.getString("nom","no_user");

        txHola.setText("Hola, "+nom+"! Tu nota final es de..");


    }
}