package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_informacao extends Fragment {
    private TextView alturafa, pesofa, imcfa, nomefa;
    private Float altura, peso, imc;
    private String nome;
    private ImageView imagemfd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informacao, container, false);

        alturafa = view.findViewById(R.id.alturaf);
        pesofa = view.findViewById(R.id.pesof);
        nomefa = view.findViewById(R.id.nomef);
        imagemfd = view.findViewById(R.id.imagemf);
        imcfa = view.findViewById(R.id.imcf);

        Bundle bundle = getArguments();

        if (bundle != null) {
            altura = bundle.getFloat("altura");
            imc = bundle.getFloat("imc");
            peso = bundle.getFloat("peso");
            nome = bundle.getString("nome");
        }

        nomefa.setText(bundle.getString("nome"));
        pesofa.setText(bundle.getString("peso"));
        alturafa.setText(bundle.getString("altura"));
        imcfa.setText(bundle.getString("imc"));

        if(imc<18.5){
            imagemfd.setImageResource(R.drawable.abaixopeso);
        }
        else if(imc<25){
            imagemfd.setImageResource(R.drawable.normal);
        }
        else if(imc<30){
            imagemfd.setImageResource(R.drawable.sobrepeso);
        }
        else if(imc<35){
            imagemfd.setImageResource(R.drawable.obesidade1);
        }
        else if(imc<40){
            imagemfd.setImageResource(R.drawable.obesidade2);
        }
        else{
            imagemfd.setImageResource(R.drawable.obesidade3);
        }

        return view;
    }
}