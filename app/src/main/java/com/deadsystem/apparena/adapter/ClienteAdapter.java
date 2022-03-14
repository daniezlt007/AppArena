package com.deadsystem.apparena.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.holder.ClienteViewHolder;
import com.deadsystem.apparena.model.Cliente;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteViewHolder> {

    private List<Cliente> mList;

    public ClienteAdapter(List<Cliente> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        Cliente cliente = this.mList.get(position);
        holder.bind(cliente);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
