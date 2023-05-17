package com.learning.lab_1_var_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fontSizeRadioGroup: RadioGroup = findViewById(R.id.fontSizeRadioGroup)
        val okButton: Button = findViewById(R.id.okButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val inputEditText: EditText = findViewById(R.id.inputEditText)

        okButton.setOnClickListener {
            val selectedFontSizeId = fontSizeRadioGroup.checkedRadioButtonId

            if (selectedFontSizeId != -1) {
                val selectedFontSize: RadioButton = findViewById(selectedFontSizeId)

                val fontSize = when(selectedFontSize.text.toString()) {
                    "Small" -> 14f
                    "Medium" -> 18f
                    "Large" -> 22f
                    else -> 18f
                }

                resultTextView.textSize = fontSize
                resultTextView.text = inputEditText.text.toString()
            } else {
                resultTextView.text = getString(R.string.error_message)
            }
        }

        cancelButton.setOnClickListener {
            fontSizeRadioGroup.clearCheck()
            inputEditText.text.clear()
            resultTextView.text = ""
        }
    }
}

