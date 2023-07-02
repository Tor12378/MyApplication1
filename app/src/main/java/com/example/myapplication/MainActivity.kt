package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextHeight = findViewById(R.id.editTextHeight)
        editTextWeight = findViewById(R.id.editTextWeight)
        editTextAge = findViewById(R.id.editTextAge)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            validateAndCalculate()
        }
    }

    private fun validateAndCalculate() {
        val name = editTextName.text.toString().trim()
        val heightText = editTextHeight.text.toString().trim()
        val weightText = editTextWeight.text.toString().trim()
        val ageText = editTextAge.text.toString().trim()

        if (name.isEmpty() || heightText.isEmpty() || weightText.isEmpty() || ageText.isEmpty()) {
            textViewResult.text = "Данные введены некорректно."
            return
        }

        val height = heightText.toFloatOrNull()
        val weight = weightText.toFloatOrNull()
        val age = ageText.toIntOrNull()

        if (height == null || weight == null || age == null) {
            textViewResult.text = "Данные введены некорректно."
            return
        }

        if (height <= 0 || height >= 250 || weight <= 0 || weight >= 250 || age <= 0 || age >= 150) {
            textViewResult.text = "Данные введены некорректно."
            return
        }

        val result = calculateResult(name, height, weight, age)
        textViewResult.text = "Ответ: $result"
    }

    private fun calculateResult(name: String, height: Float, weight: Float, age: Int): Float {
        val result = height + weight + age + name.length
        return result
    }
}