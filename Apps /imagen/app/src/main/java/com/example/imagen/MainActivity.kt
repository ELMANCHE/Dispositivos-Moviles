package com.example.imagen

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
/*
Descripción corta del problema: Mostrar imagen y mensaje

Autor: Elias Manchego Navarro
Fecha creación: 9/04/204
Fecha última modificación: 21/04/2024
*/
class MainActivity : AppCompatActivity() {
    private lateinit var spinnView: Spinner // Declaración de una variable para el Spinner
    private lateinit var setImage: ImageView // Declaración de una variable para el ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        // Llama al método onCreate de la clase padre AppCompatActivity para inicializar la actividad.
        super.onCreate(savedInstanceState)

        // Establece el diseño de la actividad como activity_main.xml
        setContentView(R.layout.activity_main)

        // Encuentra la vista del Spinner en el diseño y la asigna a la variable spinnView
        spinnView = findViewById(R.id.spiner)

        // Encuentra la vista del ImageView en el diseño y la asigna a la variable setImage
        setImage = findViewById(R.id.imageView)

        // Establece un listener para el Spinner para detectar cuándo se selecciona un elemento
        spinnView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Según la posición seleccionada en el Spinner, cambia la imagen en el ImageView
                when (position) {
                    0 -> setImage.setImageResource(R.drawable.potaxio1)
                    1 -> setImage.setImageResource(R.drawable.potaxio2)
                    2 -> setImage.setImageResource(R.drawable.potaxio3)
                    3 -> setImage.setImageResource(R.drawable.potaxio4)
                }

                // Muestra un mensaje Toast con el elemento seleccionado del Spinner
                Toast.makeText(
                    this@MainActivity,
                    "Selecciona ${parent?.getItemIdAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Método llamado cuando no se selecciona ningún elemento en el Spinner
            }
        }
    }
}

