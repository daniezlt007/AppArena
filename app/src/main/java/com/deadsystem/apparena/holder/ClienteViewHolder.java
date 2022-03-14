package com.deadsystem.apparena.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.model.Cliente;

public class ClienteViewHolder extends RecyclerView.ViewHolder {

    private TextView txtViewId, txtViewNome, txtViewApelido, txtViewCpf;

    public ClienteViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtViewId = itemView.findViewById(R.id.txt_view_id);
        this.txtViewNome = itemView.findViewById(R.id.txt_view_nome);
        this.txtViewApelido = itemView.findViewById(R.id.txt_view_apelido);
        this.txtViewCpf = itemView.findViewById(R.id.txt_view_apelido2);
    }

    public void bind(Cliente cliente){
        this.txtViewId.setText(cliente.getId().toString());
        this.txtViewNome.setText(cliente.getNomeCliente());
        this.txtViewApelido.setText(cliente.getApelidoCliente());
        this.txtViewCpf.setText(cliente.getCpfcliente());
    }

}
