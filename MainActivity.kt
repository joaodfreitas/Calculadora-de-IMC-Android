package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val height = editTextHeight.text.toString().toFloatOrNull()
            val weight = editTextWeight.text.toString().toFloatOrNull()

            if (height != null && weight != null) {
                val imc = weight / (height * height)
                val category = when {
                    imc < 18.5 -> "Abaixo do peso"
                    imc in 18.5..24.9 -> "Peso normal"
                    imc in 25.0..29.9 -> "Sobrepeso"
                    else -> "Obesidade"
                }
                textViewResult.text = "IMC: %.2f\nCategoria: %s".format(imc, category)
            } else {
                textViewResult.text = "Por favor, insira valores válidos."
            }
        }
    }
}