package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentoB extends Fragment {


    private EditText inputEmail, inputSenha;
    private Button buttonLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        inputEmail = view.findViewById(R.id.editTextEmail);
        inputSenha = view.findViewById(R.id.editTextSenha);
        buttonLogin = view.findViewById(R.id.buttonLogin);

        Bundle bundle = getArguments();
        String emailSalvo = "";
        String senhaSalva = "";

        if (bundle != null) {
            emailSalvo = bundle.getString("email");
            senhaSalva = bundle.getString("senha");
        }

        String finalEmailSalvo = emailSalvo;
        String finalSenhaSalva = senhaSalva;

        buttonLogin.setOnClickListener(v -> {
            String emailDigitado = inputEmail.getText().toString();
            String senhaDigitada = inputSenha.getText().toString();

            if (emailDigitado.equals(finalEmailSalvo) && senhaDigitada.equals(finalSenhaSalva)) {
                ((MainActivity) getActivity()).loginOk();
            } else {
                ((MainActivity) getActivity()).loginFalhou();
            }
        });

        return view;
    }
}
