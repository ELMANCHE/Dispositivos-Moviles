package com.example.reproductor_de_musica

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/*
Descripción corta del problema: spin reproductor de musica

Autor: Elias Manchego Navarro
Fecha creación: 7/04/204
Fecha última modificación: 21/04/2024
*/
class MainActivity : AppCompatActivity() {
    // Declaración de variables
    private lateinit var musicPlayer: MediaPlayer
    private lateinit var nombreCancion: TextView
    private lateinit var spinnerCanciones: Spinner
    private lateinit var controllers: List<MaterialButton>
    private val canciones = arrayOf(
        "01 Play My Drum copy.m4a",
        "02 K.O. copy.m4a",
        "04 Be the One copy.m4a",
        "13 Cry For You copy.m4a"
    )
    private var cancionActualIndex = 0 // Índice de la canción actual

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el diseño de la actividad

        // Inicialización de las variables con las vistas del diseño
        musicPlayer = MediaPlayer()
        nombreCancion = findViewById(R.id.nombreCancion)
        spinnerCanciones = findViewById(R.id.spinnerCanciones)
        controllers = listOf(
            findViewById(R.id.prev),
            findViewById(R.id.stop),
            findViewById(R.id.play),
            findViewById(R.id.next)
        )

        // Configuración del adaptador para el Spinner con la lista de canciones
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, canciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCanciones.adapter = adapter

        // Configuración del listener para el Spinner
        spinnerCanciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Cuando se selecciona una canción, se actualiza y reproduce
                val nombreCancionSeleccionada = parent?.getItemAtPosition(position) as String
                refreshSong(nombreCancionSeleccionada)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    // Función para manejar el clic en el botón de reproducción/pausa
    fun playClick(v: View) {
        if (!musicPlayer.isPlaying) {
            musicPlayer.start() // Inicia la reproducción si no está reproduciendo
            nombreCancion.visibility = View.VISIBLE // Muestra el nombre de la canción
        } else {
            musicPlayer.pause() // Pausa la reproducción si está reproduciendo
        }
    }

    // Función para manejar el clic en el botón de detener
    fun stopClick(v: View) {
        if (musicPlayer.isPlaying) {
            musicPlayer.pause() // Pausa la reproducción si está reproduciendo
        }
        musicPlayer.seekTo(0) // Reinicia la canción al principio
    }

    // Función para manejar el clic en el botón de siguiente
    fun nextClicked(v: View) {
        cancionActualIndex++ // Incrementa el índice de la canción
        refreshSong(canciones.getOrElse(cancionActualIndex) { "" }) // Actualiza y reproduce la siguiente canción
    }

    // Función para manejar el clic en el botón de anterior
    fun prevClicked(v: View) {
        cancionActualIndex-- // Decrementa el índice de la canción
        refreshSong(canciones.getOrElse(cancionActualIndex) { "" }) // Actualiza y reproduce la canción anterior
    }

    // Función para actualizar la canción actual y reproducirla
    fun refreshSong(nombreCancion: String) {
        musicPlayer.reset() // Reinicia el reproductor
        val fd = assets.openFd(nombreCancion) // Abre el archivo de la canción
        musicPlayer.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        fd.close() // Cierra el archivo de la canción
        musicPlayer.prepare() // Prepara el reproductor
        playClick(controllers[2]) // Reproduce la canción
        this.nombreCancion.text = nombreCancion // Muestra el nombre de la canción
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.release() // Libera los recursos del reproductor al destruir la actividad
    }
}

