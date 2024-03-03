package com.teoesword.recycler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teoesword.recycler.Models.SubElemento;
import com.teoesword.recycler.R;

import java.util.List;

public class SubElementoAdapter extends RecyclerView.Adapter<SubElementoAdapter.SubElementoViewHolder> {

    private List<SubElemento> subelementos;

    public SubElementoAdapter(List<SubElemento> subelementos) {
        this.subelementos = subelementos;
    }

    @NonNull
    @Override
    public SubElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subelemento, parent, false);
        return new SubElementoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubElementoViewHolder holder, int position) {
        SubElemento subElemento = subelementos.get(position);
        holder.bind(subElemento);
    }

    @Override
    public int getItemCount() {
        return subelementos.size();
    }

    public void setSubelementos(List<SubElemento> nuevosSubelementos) {
        this.subelementos.clear();
        this.subelementos.addAll(nuevosSubelementos);
        notifyDataSetChanged();
    }

    public void clearSubelementos() {
        this.subelementos.clear();
        notifyDataSetChanged();
    }

    public class SubElementoViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreSubElemento;

        public SubElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreSubElemento = itemView.findViewById(R.id.nombreSubElemento);
        }

        public void bind(SubElemento subElemento) {
            nombreSubElemento.setText(subElemento.getNombre());
        }
    }
}
