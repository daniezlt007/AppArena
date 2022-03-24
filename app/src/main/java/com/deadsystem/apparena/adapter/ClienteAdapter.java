package com.deadsystem.apparena.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.holder.ClienteViewHolder;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteViewHolder> {

    private List<ClienteEntity> mClientesList;
    private Context context;
    private ClienteViewHolder.HandleClienteClick clienteClick;

    public ClienteAdapter(Context context, ClienteViewHolder.HandleClienteClick clienteClick) {
        this.context = context;
        this.clienteClick = clienteClick;
    }

    public void setmClientesList(List<ClienteEntity> mClientesList) {
        this.mClientesList = mClientesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        return new ClienteViewHolder(view);
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        holder.bind(mClientesList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clienteClick.itemClick(mClientesList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.mClientesList == null || this.mClientesList.size() == 0) {
            return 0;
        } else {
            return this.mClientesList.size();
        }
    }

}
