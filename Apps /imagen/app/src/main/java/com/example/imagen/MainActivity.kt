package com.example.imagen

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
/*
Descripción corta del problema: Mostrar imagen y mensaje

Autor: Elias Manchego Navarro
Fecha creación: 9/04/204
Fecha última modificación: 13/04/2024
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llama al método onCreate de la clase padre AppCompatActivity
        // para inicializar la actividad.
        super.onCreate(savedInstanceState)

        // Establece el diseño de la actividad a activity_main.
        setContentView(R.layout.activity_main)

        // Encuentra la vista ImageView con el id imageView
        // y la asigna a la variable potaxio.
        val potaxio = findViewById<ImageView>(R.id.imageView)

        // Asigna un OnClickListener a la ImageView potaxio.
        potaxio.setOnClickListener{
            // Muestra un Toast con el mensaje "Potaxio" durante un tiempo largo.
            Toast.makeText(this,"Potaxio", Toast.LENGTH_LONG).show()
        }
    }
}
