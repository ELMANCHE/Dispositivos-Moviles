package com.example.myapplication

import android.media.MediaParser
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

/*
Descripción corta del problema: Mostrar imagen y mensaje

Autor: Elias Manchego Navarro
Fecha creación: 9/04/204
Fecha última modificación: 13/04/2024
*/
class MainActivity : AppCompatActivity() {

    // Lazy initialization para abrir el archivo de la canción actual.
    val fd by lazy {
        assets.openFd(cancionActual)
    }

    // Lazy initialization para el reproductor de música.
    val musicPlayer by lazy {
        val martina = MediaPlayer()
        martina.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        fd.close()
        martina.prepare()
        martina
    }

    // Lista de botones de control obtenidos de los recursos de diseño.
    val controllers by lazy {
        listOf(R.id.atras, R.id.parar, R.id.reproducir, R.id.adelante).map {
            findViewById<MaterialButton>(it)
        }
    }

    // Objeto para definir constantes de índice para los botones.
    object cj {
        val atras = 0
        val parar = 1
        val reproducir = 2
        val adelante = 3
    }

    // TextView para mostrar el nombre de la canción actual.
    val nombreCancion by lazy {
        findViewById<TextView>(R.id.nombreCancion)
    }

    // Lista de canciones filtradas obtenidas de los recursos de activos.
    val canciones by lazy {
        val nombreficheros = assets.list("")?.toList() ?: listOf()
        nombreficheros.filter { it.contains(".m4a") }
    }

    // Índice de la canción actual, con manejo de límites.
    var cancionActualIndex = 0
        set(value) {
            var v = if (value == -1) {
                canciones.size - 1
            } else {
                value % canciones.size
            }
            field = v
        }

    lateinit var cancionActual: String // Nombre de la canción actual, inicializada más tarde.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada al método onCreate de la clase base.

        // Configuración del diseño de borde a borde.
        setContentView(R.layout.activity_main)

        // Asignación de listeners a los botones de control.
        controllers[cj.reproducir].setOnClickListener(this::playclick)
        controllers[cj.parar].setOnClickListener(this::stopclik)
        controllers[cj.atras].setOnClickListener(this::prevclicked)
        controllers[cj.adelante].setOnClickListener(this::nextclicked)

        // Obtención del nombre de la canción actual y su visualización.
        cancionActual = canciones[cancionActualIndex]
        nombreCancion.text = cancionActual
    }

    // Función para manejar el clic en el botón de reproducción.
    fun playclick(v: View) {
        if (!musicPlayer.isPlaying) {
            musicPlayer.start()
            nombreCancion.visibility = View.VISIBLE
        } else {
            musicPlayer.pause()
        }
    }

    // Función para manejar el clic en el botón de detención.
    fun stopclik(v: View) {
        if (musicPlayer.isPlaying) {
            musicPlayer.pause()
        }
        musicPlayer.seekTo(0)
    }

    // Función para manejar el clic en el botón de siguiente.
    fun nextclicked(v: View) {
        cancionActualIndex++
        refreshsong()
    }

    // Función para manejar el clic en el botón de anterior.
    fun prevclicked(v: View) {
        cancionActualIndex--
        refreshsong()
    }

    // Función para actualizar la canción actual.
    fun refreshsong() {
        musicPlayer.reset()
        val fd = assets.openFd(cancionActual)
        musicPlayer.setDataSource(
            fd.fileDescriptor,
            fd.startOffset,
            fd.length
        )
        musicPlayer.prepare()
        playclick(controllers[cj.reproducir])
        nombreCancion.text = cancionActual
    }
}
