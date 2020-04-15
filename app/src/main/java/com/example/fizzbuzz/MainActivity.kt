package com.example.fizzbuzz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.fizzbuzz.domain.FizzBuzz
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val emptyMessage: String
        get() = resources.getString(R.string.empty_message)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onShoutButtonClicked(
        @Suppress("UNUSED_PARAMETER")
        view: View
    ) {
        val inputNumber = input.getIntValue()
        val messageText = if (inputNumber != null) FizzBuzz.check(inputNumber) else emptyMessage
        Log.d("MainActivity", "number = $inputNumber")

        message.text = messageText
    }

}

private fun EditText.getIntValue() = text.toString().trim().toIntOrNull()
