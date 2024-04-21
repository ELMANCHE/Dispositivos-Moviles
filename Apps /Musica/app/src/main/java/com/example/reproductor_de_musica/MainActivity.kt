package com.example.reproductor_de_musica

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

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
    private var cancionActualIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicPlayer = MediaPlayer()
        nombreCancion = findViewById(R.id.nombreCancion)
        spinnerCanciones = findViewById(R.id.spinnerCanciones)
        controllers = listOf(
            findViewById(R.id.prev),
            findViewById(R.id.stop),
            findViewById(R.id.play),
            findViewById(R.id.next)
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, canciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCanciones.adapter = adapter

        spinnerCanciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val nombreCancionSeleccionada = parent?.getItemAtPosition(position) as String
                refreshSong(nombreCancionSeleccionada)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        controllers[2].setOnClickListener(this::playClick)
        controllers[1].setOnClickListener(this::stopClick)
        controllers[0].setOnClickListener(this::prevClicked)
        controllers[3].setOnClickListener(this::nextClicked)

        refreshSong(canciones[cancionActualIndex])
    }

    fun playClick(v: View) {
        if (!musicPlayer.isPlaying) {
            musicPlayer.start()
            nombreCancion.visibility = View.VISIBLE
        } else {
            musicPlayer.pause()
        }
    }

    fun stopClick(v: View) {
        if (musicPlayer.isPlaying) {
            musicPlayer.pause()
        }
        musicPlayer.seekTo(0)
    }

    fun nextClicked(v: View) {
        cancionActualIndex++
        if (cancionActualIndex >= canciones.size) {
            cancionActualIndex = 0
        }
        refreshSong(canciones[cancionActualIndex])
    }

    fun prevClicked(v: View) {
        cancionActualIndex--
        if (cancionActualIndex < 0) {
            cancionActualIndex = canciones.size - 1
        }
        refreshSong(canciones[cancionActualIndex])
    }

    fun refreshSong(cancion: String) {
        musicPlayer.reset()
        val fd = assets.openFd(cancion)
        musicPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        fd.close()
        musicPlayer.prepare()
        nombreCancion.text = cancion
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.release()
    }
}
