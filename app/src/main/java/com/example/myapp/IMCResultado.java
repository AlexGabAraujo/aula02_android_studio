package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class IMCResultado extends AppCompatActivity {
    Button tvButtonInformation, tvButtonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvButtonInformation = findViewById(R.id.buttonInformation);
        tvButtonHelp = findViewById(R.id.buttonHelp);

        Bundle b = getIntent().getExtras();

        float peso = b.getFloat("peso");
        float altura = b.getFloat("altura");
        String nome = b.getString("nome");
        float imc = b.getFloat("imc");

        tvButtonInformation.setOnClickListener(v -> exibirInformacao(imc, altura, peso, nome));
        tvButtonHelp.setOnClickListener(v -> exibirSaude(imc, altura, peso));
    };


    private void exibirInformacao(Float imc, Float altura, Float peso, String nome) {
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putFloat("imc", imc);
        bundle.putFloat("peso", peso);
        bundle.putFloat("altura", altura);

        fragment_informacao fragmentInformacao = new fragment_informacao();
        fragmentInformacao.setArguments(bundle);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tela, fragmentInformacao);
        ft.commit();
    }

    private void exibirSaude(Float imc, Float altura, Float peso) {
        Bundle bundle = new Bundle();
        bundle.putFloat("imc", imc);
        bundle.putFloat("peso", peso);
        bundle.putFloat("altura", altura);

        fragment_saude fragmentSaude = new fragment_saude();
        fragmentSaude.setArguments(bundle);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tela, fragmentSaude);
        ft.commit();
    }
}