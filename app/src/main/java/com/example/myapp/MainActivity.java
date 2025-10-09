package com.example.myapp;

import android.app.LocaleManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button button;
    ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomes = new ArrayList<>(){{
            add("Gabriel");
            add("João");
            add("Lucas");
            add("Alex");
        }};

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nomes);

        //Define um tratamento para o evento de click sobre o botão
        button.setOnClickListener(v->{
            String nome = editText.getText().toString();
            nomes.add(nome);
            adapter.notifyDataSetChanged();
        });

        //Definir um tratamento para o evento click sovre o item da lista
        listView.setOnItemClickListener(
                (parent,view, position, id) ->{
             Toast.makeText(
                    getApplicationContext(),
                    "Elemento clicado"+nomes.get(position),
                    Toast.LENGTH_SHORT).show();
        });

        listView.setOnItemLongClickListener(
                (parent, view, position, id) ->{
                    nomes.remove(position);
                    adapter.notifyDataSetChanged();
                    return true;
                }
        );
        listView.setAdapter(adapter);
    }
}














