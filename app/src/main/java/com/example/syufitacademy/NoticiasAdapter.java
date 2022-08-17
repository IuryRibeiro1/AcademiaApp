package com.example.syufitacademy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.syufitacademy.recyclerview.adapter.TreinoAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasViewHolder> {

    private Context context;
    private ArrayList<Noticias> itens;

    public NoticiasAdapter(Context context, ArrayList<Noticias> itens) {
        this.context = context;
        this.itens = itens;

    }

    private TreinoAdapter.OnItemClickListener mListener;

    public void setOnItemClickListener(TreinoAdapter.OnItemClickListener listener) {
        mListener = listener;

    }

    @NonNull
    @Override
    public NoticiasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.noticias, parent, false);
        NoticiasViewHolder viewHolder = new NoticiasViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiasViewHolder noticiasViewHolder, int position) {

        Noticias noticias = itens.get(position);
        noticiasViewHolder.titulo.setText(noticias.getTitulo());
        noticiasViewHolder.noticia.setText(noticias.getNoticia());


    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

}

