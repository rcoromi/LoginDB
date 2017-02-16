package com.es.coro.logindb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

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

        BaseDatosCochePersona baseDatosCochePersona = new BaseDatosCochePersona( this, "midb", null, 1);

        Persona persona1 = new Persona(1, "Juan");
        Persona persona2 = new Persona(2, "Conchi");
        Persona persona3 = new Persona(3, "Manolo");

        baseDatosCochePersona.insertarpersona(persona1);
        baseDatosCochePersona.insertarpersona(persona2);
        baseDatosCochePersona.insertarpersona(persona3);

        Coche coche1 = new Coche("Ferrari", persona2);
        Coche coche2 = new Coche("Renault", persona2);
        Coche coche3 = new Coche("Fiat", persona1);


        baseDatosCochePersona.insertarcoche(coche1);
        baseDatosCochePersona.insertarcoche(coche2);
        baseDatosCochePersona.insertarcoche(coche3);

        List<Coche> cocheList = baseDatosCochePersona.consultarcoches_xpersona(persona2);

        for (Coche carro : cocheList){

            Log.e("TAG:", "Coche= "+carro.getModelo());
        }

    }
}
