package com.deadsystem.apparena.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.entities.ProdutoEntity;
import com.deadsystem.apparena.holder.ProdutoViewHolder;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoViewHolder>{

    private List<ProdutoEntity> mProdutosList;
    private Context context;
    private ProdutoViewHolder.HandleProdutoClick produtoClick;

    public ProdutoAdapter(Context context, ProdutoViewHolder.HandleProdutoClick produtoClick) {
        this.context = context;
        this.produtoClick = produtoClick;
    }

    public void setmProdutosList(List<ProdutoEntity> mProdutosList) {
        this.mProdutosList = mProdutosList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_produto_recycler, parent, false);
        return new ProdutoViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        holder.bind(mProdutosList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produtoClick.itemClick(mProdutosList.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        if (this.mProdutosList == null || this.mProdutosList.size() == 0) {
            return 0;
        } else {
            return this.mProdutosList.size();
        }
    }
}
