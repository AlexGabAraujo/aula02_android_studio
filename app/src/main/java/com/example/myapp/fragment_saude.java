package com.example.myapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class fragment_saude extends Fragment {
    private TextView textoHelp;
    private Float alturaf, pesof, imcf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saude, container, false);

        textoHelp = view.findViewById(R.id.textoSaude);

        Bundle bundle = getArguments();

        if (bundle != null) {
            alturaf = Float.parseFloat(bundle.getString("altura"));
            imcf = Float.parseFloat(bundle.getString("imc"));
            pesof = Float.parseFloat(bundle.getString("peso"));
        }

        int aux = 0;

        if(imcf < 18.5){
            while(imcf < 18.5){
                aux++;
                imcf = (pesof+aux) / (alturaf * alturaf);
            }
            textoHelp.setText("Para conseguir um IMC saudável(normal) você deve engordar "+aux+"kilos");

        }else if(imcf > 24.99){
            while(imcf > 24.99){
                aux++;
                imcf = (pesof-aux) / (alturaf * alturaf);
            }
            textoHelp.setText("Para conseguir um IMC saudável(normal) você deve emagrecer "+aux+"kilos");
        }
        return view;
    }
}