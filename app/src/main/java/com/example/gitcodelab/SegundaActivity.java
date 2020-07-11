package com.example.gitcodelab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {


    private int suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Bundle extras = getIntent().getExtras();
        String message = extras.getString("valor1");
        TextView text = findViewById(R.id.resultado);
        text.setText(message);
        suma=extras.getInt("suma");

    }
}
