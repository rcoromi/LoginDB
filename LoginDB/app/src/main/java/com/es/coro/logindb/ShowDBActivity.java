package com.es.coro.logindb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDBActivity extends AppCompatActivity {

    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db);

        //recojo el ID del cuadro de resultado
        textViewWelcome =(TextView) findViewById(R.id.textViewWelcome);

        //hacemos un intent para recoger la llamada a la actividad
        Intent intent=getIntent();

        //recogemos los parametros de entrada de nuestra actividad
        Bundle parametros =intent.getExtras();

        if (parametros != null)
        {
            String username = parametros.get("read_User").toString();
            String user_password = parametros.get("read_Password").toString();
            textViewWelcome.setText("Hola "+username+" Tu password es: "+user_password);
        }
        else
        {
            textViewWelcome.setText("Los valores introducidos son incorrectos");
        }
    }
}
