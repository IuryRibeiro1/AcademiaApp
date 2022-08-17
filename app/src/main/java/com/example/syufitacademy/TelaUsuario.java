package com.example.syufitacademy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TelaUsuario extends AppCompatActivity {

    private Button buttondeslogar;
    private EditText textnomelogado, texttelefonelogado, textemaillogado;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuariosID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);
        getSupportActionBar().hide();
        iniciarcomponentes();


    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        usuariosID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuariosID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentReference != null) {
                    textnomelogado.setText(documentSnapshot.getString("nome"));
                    texttelefonelogado.setText(documentSnapshot.getString("telefone"));
                    textemaillogado.setText(email);

                }


            }
        });

        buttondeslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(TelaUsuario.this , TelaLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void iniciarcomponentes(){
        buttondeslogar = findViewById(R.id.buttondeslogar);
        textnomelogado = findViewById(R.id.textnomelogado);
        texttelefonelogado = findViewById(R.id.texttelefonelogado);
        textemaillogado = findViewById(R.id.textemaillogado);

    }

}