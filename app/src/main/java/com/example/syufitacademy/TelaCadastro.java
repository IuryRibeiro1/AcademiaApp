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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class TelaCadastro extends AppCompatActivity {

    private EditText textnomecadastrar, textemailcadastrar, textsenhacadastrar, texttelefonecadastrar, textcpf;
    private Button buttoncadastrar;
    private ProgressBar progressBar;
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        getSupportActionBar().hide();
        iniciarcomponentes();

        buttoncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = textemailcadastrar.getText().toString();
                String senha = textsenhacadastrar.getText().toString();
                String nome = textnomecadastrar.getText().toString();
                String telefone = texttelefonecadastrar.getText().toString();
                String cpf = textcpf.getText().toString();

                if(email.isEmpty() || senha.isEmpty() || nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty()){
                    Snackbar.make(view , "Preencha todos os campos" , Snackbar.LENGTH_SHORT).show();

                }else{
                    CadastrarUsuario(view);
                }

            }
        });



    }

    public void CadastrarUsuario(View view){
        String email = textemailcadastrar.getText().toString();
        String senha = textsenhacadastrar.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.VISIBLE);
                    Snackbar.make(view, "Cadastro realizado com sucesso", Snackbar.LENGTH_SHORT).show();
                    SalvarDados();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ProximaTela();
                        }
                    }, 5000);

                } else {
                    String erro;
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Insira uma senha com no mínino 6 caractéres";

                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "E-mail já cadastrado";
                    } catch (Exception e) {
                        erro = "Erro ao cadastrar usuário";

                    }

                    Snackbar.make(view, erro, Snackbar.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void SalvarDados(){

        String nome = textnomecadastrar.getText().toString();
        String telefone = texttelefonecadastrar.getText().toString();
        String cpf = textcpf.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("nome" , nome);
        usuarios.put("telefone" , telefone);
        usuarios.put("cpf" , cpf);

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });




    }


        public void ProximaTela(){

            Intent intent = new Intent(TelaCadastro.this , MainActivity.class);
            startActivity(intent);
            finish();}

    public void iniciarcomponentes(){
        textnomecadastrar = findViewById(R.id.textnomecadastro);
        textemailcadastrar = findViewById(R.id.textemailcadastro);
        textsenhacadastrar = findViewById(R.id.textsenhacadastro);
        texttelefonecadastrar = findViewById(R.id.texttelefonecadastro);
        buttoncadastrar = findViewById(R.id.buttoncadastrar);
        progressBar = findViewById(R.id.progressBar);
        textcpf = findViewById(R.id.textcpf);


    }

}