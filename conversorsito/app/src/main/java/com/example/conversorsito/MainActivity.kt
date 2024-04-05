package com.example.conversorsito

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var fromSpinner: Spinner
    private lateinit var toSpinner: Spinner
    private lateinit var amountEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var convertButton: Button

    private val exchangeRates = mapOf(
        "USD_TO_EUR" to 0.923,
        "EUR_TO_USD" to 1.083,
        "USD_TO_GBP" to 0.792,
        "GBP_TO_USD" to 1.263,
        "USD_TO_JPY" to 150.545,
        "JPY_TO_USD" to 0.0066,
        "USD_TO_MXN" to 16.56,
        "MXN_TO_USD" to 0.0604,
        "EUR_TO_GBP" to 0.858,
        "GBP_TO_EUR" to 1.166,
        "EUR_TO_JPY" to 163.091,
        "JPY_TO_EUR" to 0.0061,
        "EUR_TO_MXN" to 17.94,
        "MXN_TO_EUR" to 0.0557,
        "GBP_TO_JPY" to 190.182,
        "JPY_TO_GBP" to 0.0053,
        "GBP_TO_MXN" to 20.92,
        "MXN_TO_GBP" to 0.0478,
        "JPY_TO_MXN" to 0.11,
        "MXN_TO_JPY" to 9.091,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fromSpinner = findViewById(R.id.spinner_from)
        toSpinner = findViewById(R.id.spinner_to)
        amountEditText = findViewById(R.id.editText_amount)
        resultTextView = findViewById(R.id.textView_result)
        convertButton = findViewById(R.id.button_convert)

        val currencies = arrayOf("USD", "EUR", "MXN", "GBP", "JPY")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, currencies)
        fromSpinner.adapter = adapter
        toSpinner.adapter = adapter

        convertButton.setOnClickListener {
            performConversion()
        }
    }

    private fun performConversion() {
        val fromCurrency = fromSpinner.selectedItem.toString()
        val toCurrency = toSpinner.selectedItem.toString()
        val amountString = amountEditText.text.toString()

        if (amountString.isNotEmpty()) {
            val amount = amountString.toDouble()
            val exchangeKey = "${fromCurrency}_TO_$toCurrency"
            val rate = exchangeRates[exchangeKey]

            if (rate != null) {
                val result = round(amount * rate * 100) / 100  // Redondear a dos decimales
                resultTextView.text = getString(R.string.conversion_result_text, result)
            } else {
                resultTextView.text = getString(R.string.conversion_error_text)
            }
        } else {
            amountEditText.error = getString(R.string.amount_error_text)
        }
    }
}
