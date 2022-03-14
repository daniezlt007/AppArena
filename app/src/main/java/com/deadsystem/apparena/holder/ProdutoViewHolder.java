package com.deadsystem.apparena.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.model.Produto;

public class ProdutoViewHolder extends RecyclerView.ViewHolder {

    private TextView txtViewId, txtViewDescricao, txtViewPreco, txtViewTipo;

    public ProdutoViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtViewId = itemView.findViewById(R.id.txt_view_id);
        this.txtViewDescricao = itemView.findViewById(R.id.txt_view_nome);
        this.txtViewPreco = itemView.findViewById(R.id.txt_view_apelido);
        this.txtViewTipo = itemView.findViewById(R.id.txt_view_apelido2);
    }

    public void bind(Produto produto){
        this.txtViewId.setText(produto.getId().toString());
        this.txtViewDescricao.setText(produto.getDescricao());
        this.txtViewPreco.setText(produto.getPrecocusto().toString());
        this.txtViewTipo.setText(produto.getTipo());
    }

}
