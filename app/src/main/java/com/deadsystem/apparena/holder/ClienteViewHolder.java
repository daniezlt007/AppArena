package com.deadsystem.apparena.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.entities.ClienteEntity;
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

    public void bind(ClienteEntity cliente){
        this.txtViewId.setText(cliente.id.toString());
        this.txtViewNome.setText(cliente.nomeCliente);
        this.txtViewApelido.setText(cliente.apelidoCliente);
        this.txtViewCpf.setText(cliente.cpfcliente);
    }

    public interface  HandleClienteClick {
        void itemClick(ClienteEntity clienteEntity);
        void removeItem(ClienteEntity clienteEntity);
        void editItem(ClienteEntity clienteEntity);
    }

}
