package com.example.syufitacademy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ImageView calculadoraIMC, logarusuario, agendaTreino;
    private RecyclerView recycler;
    private NoticiasAdapter adapter;
    private ArrayList<Noticias> itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        iniciarcomponentes();
        recycler = findViewById(R.id.recycler);
        itens = new ArrayList<Noticias>();
        adapter = new NoticiasAdapter(MainActivity.this , itens);
        itens.add(new Noticias("Segunda Feira : " , "Não haverá aula na segunda feira devido ao feriado"));
        itens.add(new Noticias("Promoção de final de semana:  " , "Neste sábado a matrícula terá 20% de desconto para os 20 primeiros"));
        itens.add(new Noticias("SyuFitness vagas para tumar da manhã: ", "Abriram 15 vagas para a turma da manhã, aproveite e venha se matricular!"));
        itens.add(new Noticias("Benefícios da musculação: " , "Uma melhor noite de sono, mais desempenho no seu trabalho, melhora de humor entre outros"));
        itens.add(new Noticias("Abertura da turma de Crossfit:" , "Nova turma de Crossfit iniciará em nossa academia. Venha e se matricule!"));
        itens.add(new Noticias("Contratamos!" , "A SyuFitness Academia procura novos profissionais na área de atendimento"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);


        calculadoraIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this , TelaCalculadora.class);
                startActivity(intent);
                finish();

            }
        });

        logarusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this , TelaUsuario.class);
                startActivity(intent);
                finish();

            }
        });


        agendaTreino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, TelaTreino.class);
                startActivity(intent);
                finish();

            }
        });

    }


    public void iniciarcomponentes(){
        calculadoraIMC = findViewById(R.id.calculadoraIMC);
        logarusuario = findViewById(R.id.logarusuario);
        agendaTreino = findViewById(R.id.agendatreino);

    }

}