package com.deadsystem.apparena.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.holder.ProdutoViewHolder;
import com.deadsystem.apparena.model.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoViewHolder>{

    private List<Produto> mList;

    public ProdutoAdapter(List<Produto> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto produto = this.mList.get(position);
        holder.bind(produto);
    }


    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
