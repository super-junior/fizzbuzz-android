package com.example.fuel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fuel_activity.*
import kotlinx.coroutines.runBlocking

class FuelActivity : AppCompatActivity() {

    data class Test(val status: String, val language: String, val barcode: Array<String>) {
        class Deserializer : ResponseDeserializable<Test> {
            override fun deserialize(content: String): Test =
                Gson().fromJson(content, Test::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fuel_activity)

        getParcelsButton.setOnClickListener { getParcelsBlocking() }
    }

    private fun getParcelsBlocking() {
		//Call Tread function to run in another outside MainThread
       Thread {
		   val (_, _, result) = "https://5e9fe71011b078001679cfdb.mockapi.io/mock-dp/parcels/1".httpGet()
			   .responseString()
		   when (result) {
			   is Result.Failure -> {
				   val ex = result.getException()
				   println(ex)
			   }
			   is Result.Success -> {
				   val data = result.get()
				   Log.d("network", data)
				   println(data)
				   //Update UI in UIThread
				   runOnUiThread{
					   textView.text = data
				   }

			   }
		   }

	   }.start()


    }

    private fun getParcelsCoroutine() {
        runBlocking {
            val (_, _, result) = "https://5e9fe71011b078001679cfdb.mockapi.io/mock-dp/parcels/1".httpGet()
                .awaitStringResponseResult()
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    println(ex)
                }
                is Result.Success -> {
                    val data = result.get()
                    Log.d("aaaa", data)
                    textView.text = data
                    println(data)
                }
            }

        }
    }

    private fun getParcelsCallBag() {
        "https://5e9fe71011b078001679cfdb.mockapi.io/mock-dp/parcels/1".httpGet()
            .responseString { _, _, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.d("aaaa", data)
                        textView.text = data
                        println(data)
                    }
                }

            }

    }
}
