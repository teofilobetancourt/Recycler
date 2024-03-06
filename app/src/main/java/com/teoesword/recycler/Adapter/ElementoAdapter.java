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

    public ElementoAdapter(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_r_segundo, parent, false);
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
        private TextView textViewEquipo;
        private RecyclerView recyclerViewSubelementos;
        private SubElementoAdapter subElementoAdapter;

        public ElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEquipo = itemView.findViewById(R.id.textViewEquipo);
            recyclerViewSubelementos = itemView.findViewById(R.id.recyclerViewSubelementos);

            // Configuración del RecyclerView de subelementos
            recyclerViewSubelementos.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            // Crear un nuevo adaptador para los subelementos
            subElementoAdapter = new SubElementoAdapter(new ArrayList<>());
            recyclerViewSubelementos.setAdapter(subElementoAdapter);

            // Agregar OnClickListener para expandir/cerrar los subelementos
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener el elemento actual
                    Elemento elemento = elementos.get(getAdapterPosition());

                    // Cambiar la visibilidad de los subelementos
                    if (recyclerViewSubelementos.getVisibility() == View.GONE) {
                        // Si la vista de subelementos está oculta, mostrarla y actualizar los subelementos
                        recyclerViewSubelementos.setVisibility(View.VISIBLE);
                        subElementoAdapter.setSubelementos(elemento.getSubelementos());
                    } else {
                        // Si la vista de subelementos ya está visible, ocultarla y borrar los subelementos
                        recyclerViewSubelementos.setVisibility(View.GONE);
                        subElementoAdapter.clearSubelementos();
                    }
                }
            });
        }

        public void bind(Elemento elemento) {
            textViewEquipo.setText(elemento.getEquipo());
            // Configuración del adaptador de subelementos
            subElementoAdapter.setSubelementos(elemento.getSubelementos());
            // Inicialmente, ocultar los subelementos
            recyclerViewSubelementos.setVisibility(View.GONE);
        }
    }
}
