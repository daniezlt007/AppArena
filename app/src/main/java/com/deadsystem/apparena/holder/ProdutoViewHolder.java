package com.deadsystem.apparena.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.entities.ProdutoEntity;
import com.deadsystem.apparena.model.Produto;

public class ProdutoViewHolder extends RecyclerView.ViewHolder {

    private TextView txtViewId, txtViewDescricao, txtViewPreco, txtViewTipo;

    public ProdutoViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtViewId = itemView.findViewById(R.id.txt_view_id);
        this.txtViewDescricao = itemView.findViewById(R.id.txt_view_nome);
        this.txtViewPreco = itemView.findViewById(R.id.txt_view_apelido);
        this.txtViewTipo = itemView.findViewById(R.id.txt_view_cpf);
    }

    public void bind(ProdutoEntity produto){
        this.txtViewId.setText(produto.id.toString());
        this.txtViewDescricao.setText(produto.descricao);
        this.txtViewPreco.setText(produto.precocusto.toString());
        this.txtViewTipo.setText(produto.tipo);
    }

    public interface  HandleProdutoClick {
        void itemClick(ProdutoEntity produtoEntity);
        void removeItem(ProdutoEntity produtoEntity);
        void editItem(ProdutoEntity produtoEntity);
    }

}
