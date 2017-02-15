package com.es.coro.logindb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    //Declaro mi cuadro de resultado
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //recojo el ID del cuadro de resultado
        textViewResult =(TextView) findViewById(R.id.textViewResult);

        //hacemos un intent para recoger la llamada a la actividad
        Intent intent=getIntent();

        //recogemos los parametros de entrada de nuestra actividad
        Bundle parametros =intent.getExtras();
        if (parametros != null) {//ver si contiene datos
            Float resultad = Float.valueOf(parametros.get("IMC").toString());
            //Como es tipo float lo convertimos para msotrarlo
            //textViewResult.setText(Float.toString(resultad));
            if ( resultad <= 0 ) {
                textViewResult.setText("Los valores introducidos son incorrectos");
            }
            else if ( resultad < 18.5 ){
                textViewResult.setText("Tu IMC es BAJO: "+Float.toString(resultad)+" - Cómete un cocidito");
            }
            else if ( resultad >= 18.5 && resultad < 24.9 ){
                textViewResult.setText("Tu IMC es NORMAL: "+Float.toString(resultad)+" - ¡Buen trabajo!");
            }
            else if ( resultad >= 25.0 && resultad < 29.9 ){
                textViewResult.setText("Tu IMC es SOBREPESO: "+Float.toString(resultad)+" - Empieza a hacer ejercicio");
            }
            else {
                textViewResult.setText("Tu IMC es OBESO: "+Float.toString(resultad)+" - Ve al endocrino");
            }
        }
    }
}
