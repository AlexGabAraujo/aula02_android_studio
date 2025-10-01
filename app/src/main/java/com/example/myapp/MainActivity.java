package com.example.myapp;

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
            //passar os dados para o bundle
            float peso = Float.parseFloat(edpeso.getText().toString());
            float altura = Float.parseFloat(edaltura.getText().toString());

            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);

            startActivity(intent);
        });
    }
}


/*

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText edpeso, edaltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.btCalculaIMC);
        edaltura = findViewById(R.id.EdAltura);
        edpeso = findViewById(R.id.EdPeso);
        b.setOnClickListener(v -> {
            Intent intent = new Intent(this, IMCResultado.class);
            //passar os dados para o bundle
            float peso = Float.parseFloat(edpeso.getText().toString());
            float altura = Float.parseFloat(edaltura.getText().toString());

            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);

            startActivity(intent);
        });
    }
}

 */














