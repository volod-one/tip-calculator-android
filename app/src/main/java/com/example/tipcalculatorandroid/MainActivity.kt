package com.example.tipcalculatorandroid

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.edit_text)
        val slider = findViewById<Slider>(R.id.slider)
        val output = findViewById<TextView>(R.id.text_view)

        fun updateOutput() {
            if (input.length() != 0) {
                val totalAmountRaw = slider.value.toDouble() / 100 * input.text.toString().toDouble()
                val totalAmount = String.format("%.2f", totalAmountRaw)
                val outputText = "Tip amount: $totalAmount"
                output.visibility = View.VISIBLE
                output.text = outputText
            } else {
                output.visibility = View.INVISIBLE
            }
        }

        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                updateOutput()
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        slider.addOnChangeListener { _, value, _ ->
            slider.value = value
            updateOutput()
        }
    }
}

