package com.example.gitcodelab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class ActNavigation1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_navigation1);

        findViewById(R.id.buttonIrAAct2).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //En esta linea guardamos una referencia al EditText donde podemos escribir el parametro que vamos a enviar a la siguiente pantalla
                        EditText text = findViewById(R.id.et_param);
                        //Aca llamamos el String que se encuentra actualmente escrito en el EditText
                        String parametro = text.getText().toString();
                        //Aca creamos el intent, el primer parametro sera getApplicationContext() y el segundo es la Clase de la activity destino o a donde vamos a navegar.
                        Intent intent = new Intent(getApplicationContext(), ActNavigation2.class);
                        //Aca agregamos el primer parametro que vamos a enviar. El primer parametro es el Key con el cual luego podemos recuperar el valor del parametro
                        intent.putExtra("parametro1", parametro);
                        //Aca agregamos el segundo parametro.
                        intent.putExtra("numero1", 10);
                        //Y esta linea "activa" o comienza la activity que definimos en el intent, con los parametros que enviamos por putExtra()
                        startActivity(intent);

                    }
                }
        );
    }
}
