package com.example.practica02javatarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText txtaltura;
    private EditText txtpeso;
    private EditText txtIMC;
    private Button btnCalcular;
    private Button btnBorrar;
    private Button btnCerrar;

    private double altura = 0.0;
    private double peso = 0.0;
    private double imc = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtaltura = findViewById(R.id.txtaltura);
        txtpeso = findViewById(R.id.txtpeso);
        txtIMC = findViewById(R.id.txtimc);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnBorrar = findViewById(R.id.btnBorrar);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtpeso.getText().clear();
                txtIMC.getText().clear();
                txtaltura.getText().clear();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtaltura.getText().toString().isEmpty() || txtpeso.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    altura = Double.parseDouble(txtaltura.getText().toString());
                    peso = Double.parseDouble(txtpeso.getText().toString());
                    altura /= 100;
                    DecimalFormat format = new DecimalFormat("#.##");
                    imc = peso / (altura * altura);
                    txtIMC.setText(format.format(imc));
                }
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
