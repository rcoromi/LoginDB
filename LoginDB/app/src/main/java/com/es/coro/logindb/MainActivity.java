package com.es.coro.logindb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        //Creamos el fichero de preferencias si no existe y si existe creamos la referecia a dicho fichero
        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        //Creamos la variable de edición del shared preferences
        SharedPreferences.Editor update_sharedpreferences= sharedPreferences.edit();
        //Creamos una variable que deberíamos tener en el shared_preferences
        Boolean firstLogging= sharedPreferences.getBoolean("firstLogging", false);

        Intent pantalla = new Intent();

        if (firstLogging == false){
            //muestro pantalla de login
           pantalla = new Intent(MainActivity.this,LoginsActivity.class);
        }
        else {
            //muestro pantalla normal
            pantalla = new Intent(MainActivity.this,CalculationActivity.class);
        }
        startActivity(pantalla);
    }

    @Override
    protected void onDestroy() {
        //Creamos el fichero de preferencias si no existe y si existe creamos la referecia a dicho fichero
        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        //Creamos la variable de edición del shared preferences
        SharedPreferences.Editor update_sharedpreferences= sharedPreferences.edit();
        update_sharedpreferences.putBoolean("firstLogging", false);
        update_sharedpreferences.commit();
        super.onDestroy();
    }
}
