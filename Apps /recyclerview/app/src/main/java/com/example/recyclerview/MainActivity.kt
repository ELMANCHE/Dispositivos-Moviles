package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val imagenFirst = listOf<potaxio>(
        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        ),

        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        ),

        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        ),

        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        ),

        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        ),

        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        ),

        potaxio(
            "uno",
            "dos",
            "tres",
            "htttps://google.com/balbla.jpg"
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}