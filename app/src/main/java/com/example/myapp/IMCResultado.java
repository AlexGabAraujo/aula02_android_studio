package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class IMCResultado extends AppCompatActivity {
    Button tvButtonInformation, tvButtonHelp;

    /*TextView tvPeso, tvAltura, tvIMC;
    ImageView tvPerfil;*/

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
        tvButtonHelp.setOnClickListener(v -> exibirSaude());
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

    private void exibirSaude() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.tela, new fragment_saude());
        ft.commit();
    }



        /*
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvIMC = findViewById(R.id.tvIMC);

        tvPerfil = findViewById(R.id.tvPerfil);*/

        /*
        tvPeso.setText(Float.toString(peso));
        tvAltura.setText(Float.toString(altura));
        tvIMC.setText(Float.toString(imc));

        if(imc<18.5){
            tvPerfil.setImageResource(R.drawable.abaixopeso);
        }
        else if(imc<25){
            tvPerfil.setImageResource(R.drawable.normal);
        }
        else if(imc<30){
            tvPerfil.setImageResource(R.drawable.sobrepeso);
        }
        else if(imc<35){
            tvPerfil.setImageResource(R.drawable.obesidade1);
        }
        else if(imc<40){
            tvPerfil.setImageResource(R.drawable.obesidade2);
        }
        else{
            tvPerfil.setImageResource(R.drawable.obesidade3);
        }*/
}



/*

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

 */



/*
---------------------------------------------------------------------------------*



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


 */