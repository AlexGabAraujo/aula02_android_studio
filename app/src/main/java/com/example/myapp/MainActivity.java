package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    Button registerButton, loginButton, menuButton;
    FragmentoA fragmentoA ;
    FragmentoB fragmentoB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerButton=findViewById(R.id.registerButton);
        loginButton=findViewById(R.id.loginButton);
        frameLayout=findViewById(R.id.tela);


        registerButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (fragmentoA ==null){
                fragmentoA =new FragmentoA();
            }

            fragmentTransaction.replace(R.id.tela,fragmentoA);
            fragmentTransaction.commit();

        });

        loginButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (fragmentoB==null){
                fragmentoB=new FragmentoB();
            }
            Bundle bundle = new Bundle();
            bundle.putString("msg","Olá ");
            fragmentoB.setArguments(bundle);
            fragmentTransaction.replace(R.id.tela,fragmentoB);
            fragmentTransaction.commit();
        });
    }
}














