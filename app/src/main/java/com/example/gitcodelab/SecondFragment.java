package com.example.gitcodelab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
        num2 = 0;
        secondTextView.setText(num2.toString());

        return secondLayout;
    }

    public void count(View view) {
        num2++;
        secondTextView.setText("Suma: "+ num2.toString());
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.navigateEmpty3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_emptyActivity2);
            }
        });


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
                count(view);
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


    }
}
