package com.example.syufitacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.syufitacademy.recyclerview.adapter.TreinoAdapter;

import java.util.ArrayList;
import java.util.List;

public class TelaTreino extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TreinoAdapter adapterdois;
    private ArrayList<Treino> itens;
    private Button buttonvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_treino);
        getSupportActionBar().hide();
        iniciarcomponentes();
        recyclerView = findViewById(R.id.recyclerDois);
        itens = new ArrayList<Treino>();
        itens.add(new Treino("Segunda-Feira: ", "Braço e Peito"));
        itens.add(new Treino("Terça-Feira: ", "Perna"));
        itens.add(new Treino("Quarta-Feira: ", "Costas e Tríceps"));
        itens.add(new Treino("Quinta-Feira: ", "Caminhada"));
        itens.add(new Treino("Sexta-Feira: ", "Braço e Peito"));
        itens.add(new Treino("Sábado: ", "Crossfit"));
        adapterdois = new TreinoAdapter(TelaTreino.this, itens);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TelaTreino.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterdois);




        buttonvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TelaTreino.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


        adapterdois.setOnItemClickListener(new TreinoAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(getApplicationContext(), itens.get(position).getTreinos(),Toast.LENGTH_SHORT).show();
            }
        });


    }



    public void iniciarcomponentes(){
        buttonvoltar = findViewById(R.id.buttonvoltar);


    }

}