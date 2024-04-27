package com.example.fragment

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

class primer_fragent : Fragment(R.layout.fragment_primer_fragent){

    private lateinit var spinnView: Spinner // Declaración de una variable para el Spinner
    private lateinit var setImage: ImageView // Declaración de una variable para el ImageView

    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        // Llama al método onCreate de la clase padre AppCompatActivity para inicializar la actividad.
        super.onViewCreated(view, savedInstanceState)

        spinnView = view.findViewById(R.id.spiner)
        setImage = view.findViewById(R.id.imageView)

        spinnView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> setImage.setImageResource(R.drawable.image1)
                    1 -> setImage.setImageResource(R.drawable.image2)
                    2 -> setImage.setImageResource(R.drawable.image3)
                    3 -> setImage.setImageResource(R.drawable.image4)
                }

                Toast.makeText(
                    requireContext(),
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



