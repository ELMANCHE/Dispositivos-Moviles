package com.example.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
/*
Descripción corta del problema: Reproductor de musica  en fragment
Lo principal fue es que trate este main como un fragment y no el main principal, por ello funciono
Autor: Elias Manchego Navarro
Fecha creación: 25/04/204
Fecha última modificación: 27/04/2024
*/
class segundo_fragent : Fragment(R.layout.fragment_segundo_fragment){

    // Declaración de variables
    private lateinit var musicPlayer: MediaPlayer
    private lateinit var nombreCancion: TextView
    private lateinit var spinnerCanciones: Spinner
    private lateinit var controllers: List<MaterialButton>
    private val canciones = arrayOf(
        "01 Best Behaviour copy.m4a",
        "01 Just Dance (feat. Colby O'Donis) copy.m4a",
        "01 Play My Drum copy.m4a",
        "01 Radioactive copy.m4a",
        "13 Cry For You copy.m4a"
    )
    private var cancionActualIndex = 0 // Índice de la canción actual

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicialización de las variables con las vistas del diseño
        musicPlayer = MediaPlayer()

        nombreCancion = view.findViewById(R.id.nombreCancion)
        spinnerCanciones = view.findViewById(R.id.spinnerCanciones)
        controllers = listOf(
            view.findViewById(R.id.prev),
            view.findViewById(R.id.stop),
            view.findViewById(R.id.play),
            view.findViewById(R.id.next)
        )


        // Configura el adaptador para el Spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, canciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCanciones.adapter = adapter

        // Configura el listener para el Spinner
        spinnerCanciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val nombreCancionSeleccionada = parent?.getItemAtPosition(position) as String
                refreshSong(nombreCancionSeleccionada)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Configura los listeners para los botones
        controllers[2].setOnClickListener { playClick() }
        controllers[1].setOnClickListener { stopClick() }
        controllers[3].setOnClickListener { nextClicked() }
        controllers[0].setOnClickListener { prevClicked() }
    }

    private fun playClick() {
        if (!musicPlayer.isPlaying) {
            musicPlayer.start()
            nombreCancion.visibility = View.VISIBLE
        } else {
            musicPlayer.pause()
        }
    }

    private fun stopClick() {
        if (musicPlayer.isPlaying) {
            musicPlayer.pause()
        }
        musicPlayer.seekTo(0)
    }

    private fun nextClicked() {
        cancionActualIndex++
        refreshSong(canciones.getOrElse(cancionActualIndex) { "" })
    }

    private fun prevClicked() {
        cancionActualIndex--
        refreshSong(canciones.getOrElse(cancionActualIndex) { "" })
    }

    private fun refreshSong(nombreCancion: String) {
        musicPlayer.reset()
        val fd = requireContext().assets.openFd(nombreCancion)
        musicPlayer.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        fd.close()
        musicPlayer.prepare() // Prepara el MediaPlayer antes de intentar reproducir
        playClick()
        this.nombreCancion.text = nombreCancion
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.release()
    }
}
