package com.teoesword.recycler.Activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teoesword.recycler.R;

public class NuevoActivity extends AppCompatActivity {

    private TextView textViewEquipoSeleccionado;
    private TextView textViewFechaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        // Obtener referencia al FloatingActionButton
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        // Obtener referencias a los TextViews
        textViewEquipoSeleccionado = findViewById(R.id.textViewEquipoSeleccionado);
        textViewFechaSeleccionada = findViewById(R.id.textView2);

        // Obtener extras del intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Obtener valores de los extras
            String valor = extras.getString("valor");
            String unit = extras.getString("unit");

            // Actualizar los TextViews con los valores recibidos
            textViewEquipoSeleccionado.setText(valor);
            textViewFechaSeleccionada.setText(unit);
        }

        // Establecer OnClickListener para el FloatingActionButton
        fab.setOnClickListener(view -> {
            // Acciones a realizar cuando se hace clic en el botón
            showToast("Comentario agregado al CML");
        });
    }

    // Método para mostrar un Toast
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
