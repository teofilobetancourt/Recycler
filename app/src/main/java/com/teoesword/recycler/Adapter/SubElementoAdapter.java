package com.teoesword.recycler.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teoesword.recycler.Activity.NuevoActivity;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_r_tercero, parent, false);
        return new SubElementoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubElementoViewHolder holder, int position) {
        SubElemento subElemento = subelementos.get(position);
        holder.bind(subElemento);

        // Agregar un OnClickListener al elemento de la lista
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un intent para abrir NuevoActivity
                Intent intent = new Intent(view.getContext(), NuevoActivity.class);

                // Puedes pasar información adicional a la nueva actividad si es necesario
                intent.putExtra("valor", subElemento.getValor());
                intent.putExtra("unit", subElemento.getUnit());

                // Iniciar la nueva actividad
                view.getContext().startActivity(intent);
            }
        });
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
        private TextView textViewValor, textViewUnit;

        public SubElementoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewValor = itemView.findViewById(R.id.textViewValor);
            textViewUnit = itemView.findViewById(R.id.textViewUnit);
        }

        public void bind(SubElemento subElemento) {
            textViewValor.setText(subElemento.getValor());
            textViewUnit.setText(subElemento.getUnit());
        }
    }
}
