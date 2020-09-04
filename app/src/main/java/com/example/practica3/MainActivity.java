package com.example.practica3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btConfig;
    private Button btContinuar;
    private EditText txNombre;
    private ConstraintLayout fondo;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        btConfig = findViewById(R.id.btConfig);
        btContinuar = findViewById(R.id.btContinuar);
        txNombre = findViewById(R.id.txNombre);
        fondo = findViewById(R.id.fondo);

        //click
        btConfig.setOnClickListener(this);
        btContinuar.setOnClickListener(this);




    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("colores", MODE_PRIVATE);
        String color = preferences.getString("color","No_color");

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btConfig:
                //shared preferences fondo
                SharedPreferences fondos1 = getSharedPreferences("colores", MODE_PRIVATE);
                fondos1.edit().putString("color", color).apply();

                //paso a la pantalla de color de fondo
                Intent a = new Intent(this, pantallaColor.class);
                startActivityForResult(a, 11);

                overridePendingTransition(R.anim.entrada, R.anim.salida);

                break;

            case R.id.btContinuar:
                String nom = txNombre.getText().toString();

                //shared preferences fondo
                SharedPreferences fondos = getSharedPreferences("colores", MODE_PRIVATE);
                fondos.edit().putString("color", color).apply();

                //shared preferences
                SharedPreferences preferences = getSharedPreferences("nombre", MODE_PRIVATE);
                preferences.edit().putString("nom", nom).apply();

                if(nom.equals("")){
                    //si no escribe un nombre no puede seguir
                    Toast.makeText(this,"Escriba su nombre", Toast.LENGTH_LONG).show();
                }else{

                    //paso a la pantalla de calculo de notas
                    Intent i = new Intent(this, pantallaCalculo.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);


                }

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 11 && resultCode == RESULT_OK){

            color = data.getExtras().getString("color");

            if(color.equals("rosa")){
                fondo.setBackgroundColor((Color.rgb(243,167,230)));
            }
            if(color.equals("azul")){
                fondo.setBackgroundColor((Color.rgb(139,214,223)));
            }
            if(color.equals("morado")){
                fondo.setBackgroundColor((Color.rgb(168,144,227)));
            }

        }else if(requestCode == 1 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Operación cancelada", Toast.LENGTH_LONG).show();
        }
    }


}