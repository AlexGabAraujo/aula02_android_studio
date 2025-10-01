package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private String emailSalvo;
    private String senhaSalva;
    private boolean isLoggedIn = false;
    private Button registerButton, loginButton, menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        menuButton = findViewById(R.id.menuButton);

        exibirFragmentoA();

        registerButton.setOnClickListener(v -> exibirFragmentoA());
        loginButton.setOnClickListener(v -> exibirFragmentoB());

        menuButton.setOnClickListener(v -> {
            if (isLoggedIn == true) {
                exibirFragmentoC();
            } else {
                Toast.makeText(this, "Faça login para acessar o menu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void exibirFragmentoA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tela, new FragmentoA());
        ft.commit();
    }

    private void exibirFragmentoB() {
        Bundle bundle = new Bundle();
        bundle.putString("email", emailSalvo);
        bundle.putString("senha", senhaSalva);

        FragmentoB fragmentoB = new FragmentoB();
        fragmentoB.setArguments(bundle);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tela, fragmentoB);
        ft.commit();
    }

    private void exibirFragmentoC() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tela, new FragmentoC());
        ft.commit();
    }

    public void salvarDados(String email, String senha) {
        this.emailSalvo = email;
        this.senhaSalva = senha;

        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void loginOk() {
        this.isLoggedIn = true;
        Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
        exibirFragmentoC();
    }

    public void loginFalhou() {
        this.isLoggedIn = false;
        Toast.makeText(this, "Email ou senha incorretos.", Toast.LENGTH_SHORT).show();
    }
}