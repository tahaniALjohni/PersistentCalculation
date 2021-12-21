package com.example.persistentcalculation

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etFirst: EditText
    lateinit var etSecond: EditText
    lateinit var btnMul: Button
    lateinit var tvText: TextView
    lateinit var sharedPreferences: SharedPreferences
    var numOne = 0f
    var numTwo = 0f
    var result = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirst = findViewById(R.id.edFirst)
        etSecond = findViewById(R.id.edSecond)
        tvText = findViewById(R.id.tvText)
        btnMul = findViewById(R.id.btnMul)

        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE)

        btnMul.setOnClickListener {
            var firstNum = etFirst.text.toString()
            var secondNum = etSecond.text.toString()

            numOne = firstNum.toFloat()
            numTwo = secondNum.toFloat()
            result = numOne * numTwo

            tvText.text = "$result"

            saveData()
        }
    }

    private fun saveData() {
        with(sharedPreferences.edit()) {
            val sharedPreferences = putFloat("name", result)
            apply()
            Toast.makeText(applicationContext, "Done Save Data ", Toast.LENGTH_SHORT).show()
        }
    }
}