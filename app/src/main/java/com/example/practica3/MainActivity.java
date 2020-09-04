package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        btConfig = findViewById(R.id.btConfig);
        btContinuar = findViewById(R.id.btContinuar);
        txNombre = findViewById(R.id.txNombre);

        //click
        btConfig.setOnClickListener(this);
        btContinuar.setOnClickListener(this);




    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btConfig:
                //paso a la pantalla de color de fondo
                Intent a = new Intent(this, pantallaColor.class);
                startActivity(a);
                overridePendingTransition(R.anim.entrada, R.anim.salida);

                break;

            case R.id.btContinuar:
                String nom = txNombre.getText().toString();

                if(nom.equals("")){
                    //si no escribe un nombre no puede seguir
                    Toast.makeText(this,"Escriba su nombre", Toast.LENGTH_LONG).show();
                }else{
                    //paso a la pantalla de calculo de notas
                    Intent i = new Intent(this, pantallaCalculo.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.entrada2, R.anim.salida2);

                    //shared preferences
                    SharedPreferences preferences = getSharedPreferences("nombre", MODE_PRIVATE);
                    preferences.edit().putString("nom", nom).apply();
                }


        }

    }
}