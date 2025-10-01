package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText nome, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.btCalculaIMC);
        nome = findViewById(R.id.Nome);
        altura = findViewById(R.id.Altura);
        peso = findViewById(R.id.Peso);

        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            float bpeso = Float.parseFloat(peso.getText().toString());
            float baltura = Float.parseFloat(altura.getText().toString());
            String bnome = nome.getText().toString();
            float bimc = bpeso/(baltura*baltura);

            intent.putExtra("altura", baltura);
            intent.putExtra("peso", bpeso);
            intent.putExtra("nome", bnome);

            startActivity(intent);
        });
    }
}

















