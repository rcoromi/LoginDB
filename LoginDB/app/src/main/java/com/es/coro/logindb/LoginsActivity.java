package com.es.coro.logindb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginsActivity extends AppCompatActivity {

    /*Primero declaramos los objetos que hemos creado gráficamente con el nombre del ID de cada objeto*/
    private Button buttonEntrar;
    private EditText editTextUser;
    private TextView textViewUser;
    private EditText editTextPassword;
    private TextView textViewPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins);

        /*Una vez creada la vista hacemos referencia al id de todos los objetos que hemos creado*/
        textViewUser = (TextView) findViewById(R.id.textViewUser);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //recogemos la informacion
                String read_User = editTextUser.getText().toString();
                String read_Password = editTextPassword.getText().toString();

                /*1º Declaramos un nuevo Intent desde la pantalla enla que estamos a la que queremos ir*/
                Intent buttonEntrar = new Intent(LoginsActivity.this,ShowDBActivity.class);

                /*2º Añadimos el parametro extra que queremos pasar y luego iniciamos la actividad*/
                buttonEntrar.putExtra("read_User", read_User);
                buttonEntrar.putExtra("read_Password", read_Password);


                //Creamos el fichero de preferencias si no existe y si existe creamos la referecia a dicho fichero
                SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                //Creamos la variable de edición del shared preferences
                SharedPreferences.Editor update_sharedpreferences= sharedPreferences.edit();
                update_sharedpreferences.putBoolean("firstLogging", true);
                update_sharedpreferences.commit();
                /*3º Iniciamos la actividad*/
                startActivity(buttonEntrar);

            }
        });


    }
}
