package com.example.fizzbuzz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.fizzbuzz.domain.FizzBuzz
import com.example.fuel.FuelActivity
import com.example.github.GitHubActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val emptyMessage: String
        get() = resources.getString(R.string.empty_message)

	lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

	    github_button.setOnClickListener( object: View.OnClickListener {
			override fun onClick(v: View?) {
				val intent = Intent(this@MainActivity, GitHubActivity::class.java)
				startActivity(intent)

			}
		})

        fuel_button.setOnClickListener {
            val intent = Intent(this@MainActivity, FuelActivity::class.java)
            startActivity(intent)
        }
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
