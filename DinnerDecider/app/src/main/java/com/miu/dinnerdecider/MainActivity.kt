package com.miu.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var inputText:EditText
    private lateinit var decision:TextView
    var foods = Foods()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById<EditText>(R.id.input_add)
        decision = findViewById<TextView>(R.id.food_text)
    }

    fun addFood(view: View) {
        val text = inputText.text.toString()
        if (text.isNotEmpty()) {
            foods.addFood(text)
            inputText.text.clear()
            val toast = Toast.makeText(applicationContext,"Added $text", Toast.LENGTH_LONG)
            toast.show();
        }
    }

    fun decideFood(view: View) {
        decision.text = foods.getRandomFood()
    }
}