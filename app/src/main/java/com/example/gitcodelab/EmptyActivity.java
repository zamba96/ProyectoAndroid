package com.example.gitcodelab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class EmptyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    static final String[] BEBIDAS = {"Seleccione una bebida", "Agua", "Limonada", "Naranjada"};
    static final int[] VALORES_BEBIDAS = {0, 1000, 1500, 2500};
    static final String LOG_TAG = "EmptyActivity>>";
    Spinner spinnerBebidas;
    TextView textoBebidas;

    //Spinner Postre
    static final String[] POSTRES = {"Seleccione un postre","Milhoja", "Brownie", "Helado"};
    static final int[] VALORES_POSTRES = {0, 3000, 3500, 2500};
    Spinner spinnerPostres;
    TextView textoPostres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        textoBebidas = findViewById(R.id.textValor1);
        textoPostres = findViewById(R.id.textPostres);

        //Asigna el spinner del XML a la variable spinner
        spinnerBebidas = findViewById(R.id.spinnerBebidas);
        //Crea un adaptador para el spinner, que va a meterle los strings que se encuentran en el arreglo "options"
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, BEBIDAS);
        //Agrega el adaptador al spinner, para que muestre todos los items de la lista "options"
        spinnerBebidas.setAdapter(adapter);
        //Selecciona esta activity como quien escucha cuando se selecciona un item
        spinnerBebidas.setOnItemSelectedListener(this);

        //Spinner Postres
        spinnerPostres = findViewById(R.id.spinnerPostre);
        //adaptador
        ArrayAdapter<String> adapterPostres = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, POSTRES);
        //Asignar adaptador al spinner postres
        spinnerPostres.setAdapter(adapterPostres);
        //Seleccionar esto como el listener
        spinnerPostres.setOnItemSelectedListener(this);

        findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                intent.putExtra("valor1", textoBebidas.getText());
                intent.putExtra("suma", 10);
                startActivity(intent);
            }
        });


    }



    public void manejarSpinner1(int pos, long id) {
        Log.w("Empty Activity Tag", "pos: " + pos);
        Log.i(LOG_TAG, "id:" + id);
        if (pos == 0) {
            textoBebidas.setText("N/A");
        } else {
            textoBebidas.setText("Valor: " + VALORES_BEBIDAS[pos]);
        }
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.spinnerBebidas: //Manejar el spinner 1
                manejarSpinner1(position, id);
                break;
            case R.id.spinnerPostre:
                manejarSpinnerPostres(position);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        textoBebidas.setText("Seleccione una opcion");
    }

    private void manejarSpinnerPostres(int position) {
        if(position == 0) {
            textoPostres.setText("N/A");
        } else {
            textoPostres.setText("Valor: " + VALORES_POSTRES[position]);
        }
    }


}
