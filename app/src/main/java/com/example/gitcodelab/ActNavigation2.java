package com.example.gitcodelab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActNavigation2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_navigation2);
        //El bundle contiene lo que uno pone en el intent con putExtra()
        Bundle datos = getIntent().getExtras();
        //Aca usamos el key que pusimos en putExtra cuando creamos el intent en ActNavigation1.
        String param = datos.getString("parametro1");
        int numero = datos.getInt("numero1");
        //Desde aca ya podemos usar los parametros que entraron con el intent que creó esta activity!
        TextView tvParam = findViewById(R.id.tvParametro);
        tvParam.setText(param + ":" + numero);

    }
}
