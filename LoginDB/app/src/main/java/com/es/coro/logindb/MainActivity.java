package com.es.coro.logindb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    float var = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // setContentView(R.layout.activity_logins);

        Intent pantalla = new Intent();
        super.onCreate(savedInstanceState);
        if ( var == 0 ) {
            pantalla = new Intent(MainActivity.this,LoginsActivity.class);
        }
        else{
            pantalla = new Intent(MainActivity.this,CalculationActivity.class);
        }
         /*3º Iniciamos la actividad*/
        startActivity(pantalla);

    }
}
