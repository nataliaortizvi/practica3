package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class pantallaCalculo extends AppCompatActivity {

    private Button btCalcular;
    private EditText txParcial1, txParcial2, txQuices, txEjercicios, txProyecto1, txProyecto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_calculo);

        //referenciar
        btCalcular = findViewById(R.id.btCalcular);
        txParcial1 = findViewById(R.id.txParcial1);
        txParcial2 = findViewById(R.id.txParcial1);
        txQuices = findViewById(R.id.txQuices);
        txEjercicios = findViewById(R.id.txEjercicios);
        txProyecto1 = findViewById(R.id.txProyecto1);
        txProyecto2 = findViewById(R.id.txProyecto2);

        //click
        btCalcular.setOnClickListener(
                (view) -> {
                    //calculo de notas
                    String parcialUno = txParcial1.getText().toString();
                    double parcial1 = Double.parseDouble(parcialUno);

                    String parcialDos = txParcial2.getText().toString();
                    double parcial2 = Double.parseDouble(parcialDos);

                    String quicesP = txQuices.getText().toString();
                    double quices = Double.parseDouble(quicesP);

                    String ejerciciosP = txEjercicios.getText().toString();
                    double ejercicios = Double.parseDouble(ejerciciosP);

                    String proyectoUno = txProyecto1.getText().toString();
                    double proyecto1 = Double.parseDouble(proyectoUno);

                    String proyectoDos = txProyecto2.getText().toString();
                    double proyecto2 = Double.parseDouble(proyectoDos);

                    double calculo = ((parcial1 * 0.15)+(parcial2*0.15)+(quices*0.15)+(ejercicios*0.05)+(proyecto1*0.25)+(proyecto2*0.25));
                    Log.d(">>>>>>>>>>>>>>>>>>>>>"," "+calculo);

                    //paso a la pantalla final
                    Intent i = new Intent(this, pantallaFinal.class);
                    i.putExtra("nota final",calculo);
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                }
        );

    }
}