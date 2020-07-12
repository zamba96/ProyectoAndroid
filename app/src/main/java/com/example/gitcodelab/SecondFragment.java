package com.example.gitcodelab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;


public class SecondFragment extends Fragment {


    TextView secondTextView;
    Integer num2;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View secondLayout = inflater.inflate(R.layout.fragment_second, container, false);

        secondTextView = secondLayout.findViewById(R.id.textview_second);
        num2 = SecondFragmentArgs.fromBundle(getArguments()).getEdad();
        secondTextView.setText(num2.toString());

        return secondLayout;
    }

    public void count(View view) {
        num2++;
        secondTextView.setText("Suma: "+ num2.toString());



    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.botonSumar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2++;
                secondTextView.setText("Suma: "+ num2.toString());
            }
        });

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View view) {
//                TextView textView = (TextView) view.findViewById(R.id.textview_second);
//                textView.setText("Hi!");
//            }
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hi!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        view.findViewById(R.id.buttonGoTestFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crear la accion de navegacion desde SecondFragment hasta TestFragment, pasando por parametro el nombre, ya que nombre no tiene un default value
                SecondFragmentDirections.ActionSecondFragmentToTestFragment action = SecondFragmentDirections.actionSecondFragmentToTestFragment("Juan");
                //Agregan el parametro "numero", el cual, como si tiene un default value, es opcional y no "TIENEN" que
                // pasarlo, pero si no lo pasan, a la otra pantalla le llega el default value
                action.setNumero(num2);
                //Aca realizan la navegacion con la accion que crearon antes.
                NavHostFragment.findNavController(SecondFragment.this).navigate(action);
            }
        });

        view.findViewById(R.id.navigateEmpty3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                SecondFragmentDirections.ActionSecondFragmentToEmptyActivity2 action = SecondFragmentDirections.actionSecondFragmentToEmptyActivity2();
                action.setParametro1("Hola, la suma es: " + num2);
                action.setNombre("Andrea");
                NavHostFragment.findNavController(SecondFragment.this).navigate(action);
            }
        });



    }
}
