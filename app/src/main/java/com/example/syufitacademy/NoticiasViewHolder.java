package com.example.syufitacademy;

import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.syufitacademy.recyclerview.adapter.TreinoAdapter;

public class NoticiasViewHolder extends RecyclerView.ViewHolder {

    TextView titulo, noticia;

    public NoticiasViewHolder(@NonNull View itemView, final TreinoAdapter.OnItemClickListener listener) {
        super(itemView);

        titulo = itemView.findViewById(R.id.titulo);
        noticia = itemView.findViewById(R.id.noticia);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                listener.OnItemClick(position);

            }
        });

    }

}
