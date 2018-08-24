package com.example.marcos.imcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtPeso;
    private EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickIMC(View view){
        Intent it = new Intent(this, ResultActivity.class);

        edtNome   = (EditText)findViewById(R.id.edtNome);
        edtPeso   = (EditText)findViewById(R.id.edtPeso);
        edtAltura = (EditText)findViewById(R.id.edtAltura);

        Bundle bundle = new Bundle();

        try {
            bundle.putString("nome", edtNome.getText().toString());
            bundle.putFloat("peso", Float.parseFloat(edtPeso.getText().toString()));
            bundle.putFloat("altura", Float.parseFloat(edtAltura.getText().toString()));
        }
        catch(Exception e){
            Toast.makeText(this, "Por favor, forneça os parametros corretos!", Toast.LENGTH_LONG).show();
        }

        it.putExtras(bundle);

        startActivity(it);
    }
}
