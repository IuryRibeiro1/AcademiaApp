package com.example.syufitacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TelaLogin extends AppCompatActivity {

    private TextView textcadastrar;
    private EditText textemail, textsenha;
    private Button buttonlogar;
    private ProgressBar progressBarDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();
        iniciarcomponentes();

        textcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TelaLogin.this , TelaCadastro.class);
                startActivity(intent);
                finish();

            }
        });

        buttonlogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = textemail.getText().toString();
                String senha = textsenha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Snackbar.make(view, "Preencha todos os campos" , Snackbar.LENGTH_SHORT).show();

                }else{
                    LogarUsuario(view);
                }

            }
        });

    }

    public void LogarUsuario(View view){
        String email = textemail.getText().toString();
        String senha = textsenha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBarDois.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ProximaTela();
                        }
                    }, 3000);
                }else{
                    String erro;
                    try {
                        throw task.getException();
                    }catch (Exception e){
                        erro = "Erro ao logar usuário";
                    }
                    Snackbar.make(view, erro, Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser usuarioatual = FirebaseAuth.getInstance().getCurrentUser();
        if(usuarioatual != null){
            ProximaTela();
        }
    }

    public void ProximaTela(){

        Intent intent = new Intent(TelaLogin.this , MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void iniciarcomponentes(){
        textcadastrar = findViewById(R.id.textcadastrar);
        textemail = findViewById(R.id.textemail);
        textsenha = findViewById(R.id.textsenha);
        buttonlogar = findViewById(R.id.buttonlogar);
        progressBarDois = findViewById(R.id.progressBarDois);

    }

}