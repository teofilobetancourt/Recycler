package com.teoesword.recycler.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.teoesword.recycler.Adapter.CategoriaAdapter;
import com.teoesword.recycler.Models.Categoria;
import com.teoesword.recycler.Models.Elemento;
import com.teoesword.recycler.Models.SubElemento;
import com.teoesword.recycler.R;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategorias;
    private CategoriaAdapter categoriaAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategorias = findViewById(R.id.recyclerViewCategorias);

        // Configuración del RecyclerView de categorías
        categoriaAdapter = new CategoriaAdapter(getCategorias());
        recyclerViewCategorias.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCategorias.setAdapter(categoriaAdapter);
    }

    private List<Categoria> getCategorias() {
        // Implementa la lógica para obtener las categorías reales (puede ser desde una base de datos, recursos, etc.)
        // Por ahora, usaremos datos de ejemplo
        List<Categoria> categorias = new ArrayList<>();

        List<Elemento> elementosCategoria1 = obtenerElementosEjemplo();
        List<Elemento> elementosCategoria2 = obtenerElementosEjemplo();

        Categoria categoria1 = new Categoria("0001-1", "6/3/2024", "medicion",  elementosCategoria1);
        Categoria categoria2 = new Categoria("0002-2", "6/3/2024", "medicion", elementosCategoria2);

        categorias.add(categoria1);
        categorias.add(categoria2);

        return categorias;
    }

    private List<Elemento> obtenerElementosEjemplo() {
        // Implementa la lógica para obtener los elementos reales
        List<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento("equipo 1", obtenerSubelementosEjemplo()));
        elementos.add(new Elemento("equipo 2", obtenerSubelementosEjemplo()));
        return elementos;
    }

    private List<SubElemento> obtenerSubelementosEjemplo() {
        // Implementa la lógica para obtener los subelementos reales
        List<SubElemento> subelementos = new ArrayList<>();
        subelementos.add(new SubElemento("500","metros"));
        subelementos.add(new SubElemento("700","kilos"));
        return subelementos;
    }
}
