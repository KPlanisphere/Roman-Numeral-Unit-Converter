package com.example.romanos
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberInput = findViewById<EditText>(R.id.numberInput)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        convertButton.setOnClickListener {
            val number = numberInput.text.toString().toInt()
            val romanNumber = convertToRoman(number)
            resultText.text = romanNumber
        }
    }

    private fun convertToRoman(number: Int): String {
        val romanNumerals = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val nums = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        var i = 0
        var num = number
        var roman = ""

        while (num > 0 && i < nums.size) {
            while (num >= nums[i]) {
                num -= nums[i]
                roman += romanNumerals[i]
            }
            i++
        }

        return roman
    }
}
