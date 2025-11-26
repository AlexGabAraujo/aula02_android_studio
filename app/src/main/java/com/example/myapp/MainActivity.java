package com.example.myapp;

import android.app.LocaleManager;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText editText;
    Button saveButton;
    Button deleteButton;
    Button updateButton;

    ListView listView;
    int selectedId = -1;
    ArrayList<String> notasList = new ArrayList<>();
    ArrayList<Integer> notasIds = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        saveButton = findViewById(R.id.button);
        deleteButton = findViewById(R.id.buttonExcluir);
        updateButton = findViewById(R.id.buttonAlterar);
        saveButton = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        database = openOrCreateDatabase("app_database", MODE_PRIVATE, null);

        database.execSQL("CREATE TABLE IF NOT EXISTS notas ("+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"+"name VARCHAR, texto VARCHAR)");

        carregarNotas();

        saveButton.setOnClickListener(v -> {
            String texto = editText.getText().toString();
            if(!texto.isEmpty()){
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", texto);
                contentValues.put("texto", texto);
                database.insert("notas", null, contentValues);
            }

            carregarNotas();
            editText.setText("");
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedId = notasIds.get(position);
            editText.setText(notasList.get(position));
        });

        deleteButton.setOnClickListener(v -> {
            if (selectedId != -1) {
                database.delete("notas", "id = ?", new String[]{String.valueOf(selectedId)});
                carregarNotas();
                editText.setText("");
                selectedId = -1;
            }
        });

        updateButton.setOnClickListener(v -> {
            if (selectedId != -1) {
                String novoTexto = editText.getText().toString();

                if (!novoTexto.isEmpty()) {
                    ContentValues values = new ContentValues();
                    values.put("texto", novoTexto);

                    database.update("notas", values, "id = ?", new String[]{ String.valueOf(selectedId) });

                    carregarNotas();
                    editText.setText("");
                    selectedId = -1;
                }
            }
        });
    }

    public void carregarNotas(){
        notasList.clear();
        notasIds.clear();

        Cursor cursor = database.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int idColumn = cursor.getColumnIndex("id");
            int textoColumn = cursor.getColumnIndex("texto");

            int id = cursor.getInt(idColumn);
            String texto = cursor.getString(textoColumn);

            notasList.add(texto);
            notasIds.add(id);

            cursor.moveToNext();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notasList);
        listView.setAdapter(adapter);
    }

}














