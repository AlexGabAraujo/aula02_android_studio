package com.example.myapp;

import android.app.LocaleManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

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














