package com.es.coro.logindb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    /*Primero declaramos los objetos que hemos creado gráficamente con el nombre del ID de cada objeto*/
    private Button buttonCalcular;
    private EditText editTextAltura;
    private TextView textViewAltura;
    private EditText editTextPeso;
    private TextView textViewPeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);


        /*Una vez creada la vista hacemos referencia al id de todos los objetos que hemos creado*/
        textViewAltura = (TextView) findViewById(R.id.textViewAltura);
        editTextAltura = (EditText) findViewById(R.id.editTextAltura);
        textViewPeso = (TextView) findViewById(R.id.textViewPeso);
        editTextPeso = (EditText) findViewById(R.id.editTextPeso);
        buttonCalcular = (Button) findViewById(R.id.buttonCalcular);

        /*Ahora declaramos las interacciones entre los objectos*/
        /*En este caso cuando se haga click el text view tomará el valor de Edit_Text*/
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*leemos el texto introducido en el edittext y lo convertimos a float*/
                float read_FloatAltura = Float.valueOf(editTextAltura.getText().toString());
                float read_FloatPeso = Float.valueOf(editTextPeso.getText().toString());
                float IMC;
                /*Clculamos el IMC*/
                if (read_FloatAltura * read_FloatAltura == 0) {
                    //no podemos dividir por cero asiq el valor final del IMC es 0 y mostramos el error al calcular
                    IMC = 0;
                } else {
                    //Si no es cero calculamos el IMC por la formula general
                    IMC = read_FloatPeso / (read_FloatAltura * read_FloatAltura);
                }

                /*1º Declaramos un nuevo Intent desde la pantalla enla que estamos a la que queremos ir*/
                Intent buttonCalcular = new Intent(CalculationActivity.this,ResultActivity.class);

                /*2º Añadimos el parametro extra que queremos pasar y luego iniciamos la actividad*/
                buttonCalcular.putExtra("IMC", IMC);

                /*3º Iniciamos la actividad*/
                startActivity(buttonCalcular);
            }
        });
    }
}
