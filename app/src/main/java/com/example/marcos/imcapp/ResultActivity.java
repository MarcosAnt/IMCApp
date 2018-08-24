package com.example.marcos.imcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    private Intent it;
    private TextView tvIMC;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvIMC = (TextView)findViewById(R.id.tvIMC);
        tvDesc = (TextView)findViewById(R.id.tvDesc);

        try {
            it = getIntent();

            Bundle bundle = it.getExtras();
            String nome   = bundle.getString("nome");
            Float  peso   = bundle.getFloat("peso");
            Float  altura = bundle.getFloat("altura");

            Float IMC = calcularIMC(peso, altura);
            String descricaoIMC = classificaIMC(IMC);

            tvIMC.setText(nome + ", seu IMC é: " + String.valueOf(IMC));
            tvDesc.setText("Descrição: " + descricaoIMC);

        }
        catch(NullPointerException e) {
            tvIMC.setText("");
            tvDesc.setText("");

            Toast.makeText(this, "Parametros não encotnrados. Por favor, tente novamente.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Calcular IMC - Índicie de Massa Corporal
     * @param peso
     * @param altura
     * @return IMC
     */
    private Float calcularIMC(Float peso, Float altura) {
        Float aux, result;

        aux = altura * altura;
        result = peso / aux;
        return result;
    }

    /**
     * Fornece uma descrição para o valor de IMC informado
     * @param IMC
     * @return Descrição do IMC
     */
    private String classificaIMC(Float IMC) {

        String descricao;

        if (IMC <= 15) {
            descricao = "Extremamente abaixo do peso";
        }
        else if(IMC <= 16) {
            descricao = "Gravemente abaixo do peso";
        }
        else if(IMC <= 18.5) {
            descricao = "Abaixo do peso ideal";
        }
        else if(IMC <= 25) {
            descricao = "Faixa de peso ideal";
        }
        else if(IMC <= 30) {
            descricao = "Sobrepeso";
        }
        else if(IMC <= 35) {
            descricao = "Obesidade grau I";
        }
        else if(IMC <= 40) {
            descricao = "Obesidade grau II (grave)";
        }
        else {
            descricao = "Obesidade grau III (mórbida)";
        }

        return descricao;
    }
}
