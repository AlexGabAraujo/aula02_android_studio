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

    private TextView alturaf, pesof, imcf, nomef;
    private ImageView imagemfd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informacao, container, false);

        alturaf = view.findViewById(R.id.alturaf);
        pesof = view.findViewById(R.id.pesof);
        nomef = view.findViewById(R.id.nomef);
        imagemfd = view.findViewById(R.id.imagemf);
        imcf = view.findViewById(R.id.imcf);


        return view;
    }
}


/*

 private EditText inputEmail, inputSenha;
    private Button buttonCadastrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        inputEmail = view.findViewById(R.id.editTextEmail);
        inputSenha = view.findViewById(R.id.editTextSenha);
        buttonCadastrar = view.findViewById(R.id.buttonLogin);

        buttonCadastrar.setOnClickListener(v -> {
            String email = inputEmail.getText().toString();
            String senha = inputSenha.getText().toString();

            if (!email.isEmpty() && !senha.isEmpty()) {
                ((MainActivity) getActivity()).salvarDados(email, senha);
            }
        });

        return view;
    }
}

 */