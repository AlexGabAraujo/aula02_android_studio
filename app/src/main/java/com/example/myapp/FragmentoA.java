package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentoA extends Fragment {
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
