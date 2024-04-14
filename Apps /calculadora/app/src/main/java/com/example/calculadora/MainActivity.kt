package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
/*
Descripción corta del problema: calculadora

Autor: Elias Manchego Navarro
Fecha creación: 7/04/204
Fecha última modificación: 13/04/2024
*/
class MainActivity : AppCompatActivity() {
    // Variables para almacenar el operador y los números ingresados
    var oper: Int = 0  // Almacena el operador seleccionado: 1 para suma, 2 para resta, 3 para multiplicación, 4 para división
    var numero1: Double = 0.0  // Almacena el primer número ingresado para la operación
    lateinit var entrada_2: TextView // TextView para mostrar la operación actual
    lateinit var entrada_1: TextView // TextView para mostrar el número ingresado o el resultado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de los TextView y los botones
        entrada_1 = findViewById(R.id.entrada_2)
        entrada_2 = findViewById(R.id.entrada_1)
        val borrar: Button = findViewById(R.id.borrar)
        val igual: Button = findViewById(R.id.igual)

        // Acción del botón "igual" para calcular el resultado
        igual.setOnClickListener{
            // Se obtiene el segundo número ingresado como Double
            var numero2: Double = entrada_2.text.toString().toDouble()
            var respuesta: Double = 0.0

            // Se realiza la operación según el operador almacenado
            when(oper){
                1 -> respuesta = numero1 + numero2 // Suma
                2 -> respuesta = numero1 - numero2 // Resta
                3 -> respuesta = numero1 * numero2 // Multiplicación
                4 -> respuesta = numero1 / numero2 // División
            }

            // Se muestra el resultado en entrada_2 y se borra el contenido de entrada_1
            entrada_2.setText(respuesta.toString())
            entrada_1.setText("")
        }

        // Acción del botón "borrar" para limpiar los TextView y reiniciar las variables
        borrar.setOnClickListener{
            entrada_1.setText("")
            entrada_2.setText("")
            numero1 = 0.0
            oper = 0
        }
    }

    // Función para manejar los eventos de los botones numéricos y el punto decimal
    fun presionar(view:View){
        var num2 : String = entrada_2.text.toString()

        // Se concatena el número o el punto a entrada_2
        when(view.id){
            R.id.bt0 -> entrada_2.setText(num2 + "0")
            R.id.bt1 -> entrada_2.setText(num2 + "1")
            R.id.bt2 -> entrada_2.setText(num2 + "2")
            R.id.bt3 -> entrada_2.setText(num2 + "3")
            R.id.bt4 -> entrada_2.setText(num2 + "4")
            R.id.bt5 -> entrada_2.setText(num2 + "5")
            R.id.bt6 -> entrada_2.setText(num2 + "6")
            R.id.bt7 -> entrada_2.setText(num2 + "7")
            R.id.bt8 -> entrada_2.setText(num2 + "8")
            R.id.bt9 -> entrada_2.setText(num2 + "9")
            R.id.punto -> entrada_2.setText(num2 + ".")
        }
    }

    // Función para manejar los eventos de los botones de operación (+, -, *, /)
    fun clickope(view: View) {
        // Se obtiene el primer número ingresado como Double
        numero1 = entrada_2.text.toString().toDouble()
        var num2text: String = entrada_2.text.toString()
        entrada_2.setText("")

        // Se muestra la operación seleccionada en entrada_1 y se almacena el operador correspondiente
        when (view.id) {
            R.id.suma -> {
                entrada_1.setText(num2text + "+")
                oper = 1
            }
            R.id.menos -> {
                entrada_1.setText(num2text + "-")
                oper = 2
            }
            R.id.multiplicar -> {
                entrada_1.setText(num2text + "*")
                oper = 3
            }
            R.id.dividir -> {
                entrada_1.setText(num2text + "/")
                oper = 4
            }
        }
    }
}

// funcional 