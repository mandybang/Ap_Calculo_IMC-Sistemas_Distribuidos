package com.amandafonseca.appcalculoimc;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    EditText TvPeso;
    EditText TvAltura;
    Button button;
    TextView TvIMCR;
    TextView TvIMCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TvAltura = findViewById(R.id.Tv_Altura);
        TvPeso = findViewById(R.id.Tv_Peso);
        button = findViewById(R.id.button);
        TvIMCR = findViewById(R.id.Tv_IMCR);
        TvIMCS = findViewById(R.id.Tv_IMCS);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(TvPeso.getText().toString());
                double altura = Double.parseDouble(TvAltura.getText().toString());
                double calculo = peso / Math.pow(altura, 2);
                String situacao = validarSituacao(calculo);

                TvIMCR.setText(String.format("%.1f", calculo)); //Isso deu erro, tive que verificar no git do professor.
                TvIMCS.setText(situacao);
            }
        });
    }
           private String validarSituacao (double calculo) { //Isso deu erro, tive que verificar no git do professor.
               String situacao;
               if (calculo <= 18.5) {
                   situacao = "Abaixo do peso";
               } else if (calculo <= 24.9) {
                   situacao = "Peso Normal";
               } else if (calculo <= 29.9) {
                   situacao = "Sobrepeso";
               } else if (calculo <= 34.9) {
                   situacao = "Obesidade grau 1";
               } else if (calculo <= 39.9) {
                   situacao = "Obesidade grau 2";
               } else {
                   situacao = "Obesidade grau 3";
               }
               return situacao;
                }
           }


