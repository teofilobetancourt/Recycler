// ElementoAdapter.java
package com.teoesword.recycler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teoesword.recycler.Models.Elemento;
import com.teoesword.recycler.R;

import java.util.ArrayList;
import java.util.List;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ElementoViewHolder> {

    private List<Elemento> elementos;

    public ElementoAdapter(List<Elemento> elementos, RecyclerView recyclerViewSubelementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_elemento, parent, false);
        return new ElementoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {
        Elemento elemento = elementos.get(position);
        holder.bind(elemento);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public void setElementos(List<Elemento> nuevosElementos) {
        this.elementos = nuevosElementos;
        notifyDataSetChanged();
    }

    public void clearElementos() {
        this.elementos.clear();
        notifyDataSetChanged();
    }

    public class ElementoViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreElemento;
        private RecyclerView recyclerViewSubelementos;
        private SubElementoAdapter subElementoAdapter;

        public ElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreElemento = itemView.findViewById(R.id.nombreElemento);
            recyclerViewSubelementos = itemView.findViewById(R.id.recyclerViewSubelementos);

            // Configuración del RecyclerView de subelementos
            recyclerViewSubelementos.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            // Crear un nuevo adaptador para los subelementos
            subElementoAdapter = new SubElementoAdapter(new ArrayList<>());
            recyclerViewSubelementos.setAdapter(subElementoAdapter);
        }

        public void bind(Elemento elemento) {
            nombreElemento.setText(elemento.getNombre());
            // Configuración del adaptador de subelementos
            subElementoAdapter.setSubelementos(elemento.getSubelementos());
        }
    }
}
