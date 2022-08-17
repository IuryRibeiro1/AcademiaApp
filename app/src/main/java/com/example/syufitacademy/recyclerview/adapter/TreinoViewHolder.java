package com.example.syufitacademy.recyclerview.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.syufitacademy.R;
import com.google.android.material.snackbar.Snackbar;


public class TreinoViewHolder extends RecyclerView.ViewHolder {

    public TextView treino;
    public TextView dia;
    public ImageView buttonalterar, buttonremover, buttonadd;

    public TreinoViewHolder(@NonNull View itemView,final TreinoAdapter.OnItemClickListener listener) {
        super(itemView);

        treino = itemView.findViewById(R.id.texttreino);
        dia = itemView.findViewById(R.id.textdias);
        buttonalterar = (ImageView) itemView.findViewById(R.id.asset_alterar);
        buttonremover = (ImageView) itemView.findViewById(R.id.asset_deletar);
        buttonadd = (ImageView) itemView.findViewById(R.id.assetadd);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int position = getAdapterPosition();
                listener.OnItemClick(position);
            }
        });


    }

}
