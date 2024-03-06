package com.teoesword.recycler.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teoesword.recycler.Models.Categoria;
import com.teoesword.recycler.R;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

    private List<Categoria> categorias;

    public CategoriaAdapter(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_r_primero, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.bind(categoria);
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {
        private TextView tvid_tarea, textViewFecha, textViewDescripcionTarea;
        private RecyclerView recyclerViewElementos;
        private ElementoAdapter elementoAdapter;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvid_tarea = itemView.findViewById(R.id.tvid_tarea);
            textViewFecha = itemView.findViewById(R.id.textViewFecha);
            textViewDescripcionTarea= itemView.findViewById(R.id.textViewDescripcionTarea);
            recyclerViewElementos = itemView.findViewById(R.id.recyclerViewElementos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener la categoría actual
                    Categoria categoria = (Categoria) tvid_tarea.getTag();

                    // Cambiar la visibilidad de los elementos
                    if (recyclerViewElementos.getVisibility() == View.GONE) {
                        // Si la vista de elementos está oculta, mostrarla y actualizar los elementos
                        recyclerViewElementos.setVisibility(View.VISIBLE);
                        categoria.setExpanded(true); // Marcar como expandida
                    } else {
                        // Si la vista de elementos ya está visible, ocultarla y borrar los elementos
                        recyclerViewElementos.setVisibility(View.GONE);
                        categoria.setExpanded(false); // Marcar como no expandida
                    }
                    notifyDataSetChanged(); // Notificar al adaptador sobre el cambio
                }
            });
        }

        public void bind(Categoria categoria) {
            tvid_tarea.setText(categoria.getid_tarea());
            textViewFecha.setText(categoria.getfecha());
            textViewDescripcionTarea.setText(categoria.getDescripcion());
            // Guardar la categoría actual como una etiqueta en el nombreCategoria
            tvid_tarea.setTag(categoria);

            // Configurar el RecyclerView para los elementos
            recyclerViewElementos.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            // Crear un nuevo adaptador para los elementos
            elementoAdapter = new ElementoAdapter(categoria.getElementos());
            recyclerViewElementos.setAdapter(elementoAdapter);

            // Establecer la visibilidad inicial del RecyclerView según la categoría
            recyclerViewElementos.setVisibility(categoria.isExpanded() ? View.VISIBLE : View.GONE);
        }
    }
}
