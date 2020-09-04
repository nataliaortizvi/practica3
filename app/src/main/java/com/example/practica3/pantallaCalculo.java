package com.example.practica3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pantallaCalculo extends AppCompatActivity {

    private Button btCalcular;
    private EditText txParcial1, txParcial2, txQuices, txEjercicios, txProyecto1, txProyecto2;
    private ConstraintLayout fondo;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.entrada, R.anim.salida);
    }

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

        //click
        btCalcular.setOnClickListener(
                (view) -> {
                    String parcialUno = txParcial1.getText().toString();
                    String parcialDos = txParcial2.getText().toString();
                    String quicesP = txQuices.getText().toString();
                    String ejerciciosP = txEjercicios.getText().toString();
                    String proyectoUno = txProyecto1.getText().toString();
                    String proyectoDos = txProyecto2.getText().toString();

                    if((parcialUno.equals("")) || (parcialDos.equals("")) || (quicesP.equals("")) || (ejerciciosP.equals("")) || (proyectoUno.equals("")) || (proyectoDos.equals(""))){
                        //si alguno de las celdas está vacia no hace el calculo
                        Toast.makeText(this,"Llene todas las notas", Toast.LENGTH_LONG).show();

                    }else{
                        //calculo de notas
                        //notas a double

                        double parcial1 = Double.parseDouble(parcialUno);
                        double parcial2 = Double.parseDouble(parcialDos);
                        double quices = Double.parseDouble(quicesP);
                        double ejercicios = Double.parseDouble(ejerciciosP);
                        double proyecto1 = Double.parseDouble(proyectoUno);
                        double proyecto2 = Double.parseDouble(proyectoDos);

                        double calculo = ((parcial1 * 0.15)+(parcial2*0.15)+(quices*0.15)+(ejercicios*0.05)+(proyecto1*0.25)+(proyecto2*0.25));

                        Log.d(">>>>>>>>>>>>>>>>>>>>>"," "+calculo);

                        //paso a la pantalla final
                        Intent i = new Intent(this, pantallaFinal.class);
                        i.putExtra("nota final",calculo);
                        startActivity(i);
                        finish();
                        overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                    }

                }
        );



    }


}