package com.deadsystem.apparena.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.entities.ClienteEntity;

public class ClienteViewHolder extends RecyclerView.ViewHolder {

    private TextView txtViewId, txtViewNome, txtViewApelido, txtViewCpf, txtViewCelular;

    public ClienteViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtViewId = itemView.findViewById(R.id.txt_view_id);
        this.txtViewNome = itemView.findViewById(R.id.txt_view_nome);
        this.txtViewApelido = itemView.findViewById(R.id.txt_view_apelido);
        this.txtViewCpf = itemView.findViewById(R.id.txt_view_cpf);
        this.txtViewCelular = itemView.findViewById(R.id.txt_view_celular);
    }

    public void bind(ClienteEntity cliente){
        this.txtViewId.setText("Id: " + cliente.id.toString());
        this.txtViewNome.setText("Nome: " + cliente.nomeCliente);
        this.txtViewApelido.setText("Apelido: " + cliente.apelidoCliente);
        this.txtViewCpf.setText("Cpf: " + cliente.cpfcliente);
        this.txtViewCelular.setText("Celular: " + cliente.telefoneCliente);
    }

    public interface  HandleClienteClick {
        void itemClick(ClienteEntity clienteEntity);
        void removeItem(ClienteEntity clienteEntity);
        void editItem(ClienteEntity clienteEntity);
    }

}
