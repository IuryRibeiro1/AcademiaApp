package com.example.syufitacademy.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.syufitacademy.R;
import com.example.syufitacademy.Treino;


import java.util.ArrayList;

public class TreinoAdapter extends RecyclerView.Adapter<TreinoViewHolder> {

    private Context context;
    private ArrayList<Treino> itens;

    public TreinoAdapter(ArrayList<Object> objects) {
    }

    public interface  OnItemClickListener{
        void OnItemClick(int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;

    }


    public TreinoAdapter(Context context, ArrayList<Treino> itens) {
        this.context = context;
        this.itens = itens;

    }


    @NonNull
    @Override
    public TreinoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.treinosemanal,parent,false);
        TreinoViewHolder treinoViewHolder = new TreinoViewHolder(view, mListener);
        return treinoViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull TreinoViewHolder treinoViewHolder, int position) {
        Treino treino = itens.get(position);
        treinoViewHolder.dia.setText(treino.getDias());
        treinoViewHolder.treino.setText(treino.getTreinos());

        treinoViewHolder.buttonalterar.setOnClickListener(view -> updateItem(position));
        treinoViewHolder.buttonremover.setOnClickListener(view -> removerItem(position));
        treinoViewHolder.buttonadd.setOnClickListener(view -> updateList(treino));

        }

        private void removerItem(int position){
            itens.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, itens.size());
    }
    public void updateList(Treino treino) {
        insertItem(treino);
    }

    private void insertItem(Treino treino) {
        itens.add(treino);
        notifyItemInserted(getItemCount());
    }
    private void updateItem(int position) {
        Treino treino = itens.get(position);
        treino.setTreinos("Perna");
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return itens != null ? itens.size() : 0;
    }

}
