package com.example.syufitacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TelaCalculadora extends AppCompatActivity {

    private EditText textpeso, textaltura;
    private Button buttoncalcular;
    private TextView textresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calculadora);
        iniciarcomponentes();
        getSupportActionBar().hide();

        buttoncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double peso = Double.parseDouble(textpeso.getText().toString());
                double altura = Double.parseDouble(textaltura.getText().toString());

                double resultado = peso / (altura * altura);

                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                String resultadoformatado = decimalFormat.format(resultado);


                if (resultado < 18.5){
                    textresultado.setText("Seu IMC é: " + resultadoformatado + " Abaixo do peso");
                }else if  (resultado == 18.5 || resultado <= 24.9){
                    textresultado.setText("Seu IMC é:  " + resultadoformatado + " Peso normal" ) ;
                }else if (resultado == 25 || resultado <= 29.9){
                    textresultado.setText("Seu IMC é: " + resultadoformatado + " Acima do peso");
                }else if (resultado == 30 || resultado <= 34.9){
                    textresultado.setText("Seu IMC é: " + resultadoformatado + " Obesidade Grau I");
                }else if (resultado == 35 || resultado <= 39.9){
                    textresultado.setText("Seu IMC é: " + resultadoformatado + " Obesidade Grau II");
                }else if (resultado > 40){
                    textresultado.setText("Seu IMC é: " + resultadoformatado + " Obesidade Grau III");
                }

            }
        });

    }

    public void iniciarcomponentes(){
        textpeso = findViewById(R.id.textpeso);
        textaltura = findViewById(R.id.textaltura);
        buttoncalcular = findViewById(R.id.buttoncalcular);
        textresultado = findViewById(R.id.textresultado);

    }

}