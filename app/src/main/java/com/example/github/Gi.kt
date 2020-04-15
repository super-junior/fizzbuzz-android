package com.example.github

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Gi : IGithubHttpClient {
	override fun retrieveRepo(name: String): MutableLiveData<String> {
		val retrofit = Retrofit.Builder()
			.baseUrl("https://api.github.com")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
		val githubService = retrofit.create(GitHubService::class.java)

		var data = MutableLiveData<String>()

		githubService
			.getRepo(name)
			.enqueue(object : Callback<String> {
			override fun onResponse(
				call: Call<String>,
				response: Response<String>
			) {
				data.value = response.toString();
			}

			override fun onFailure(call: Call<String>, t: Throwable) {
				TODO("Not yet implemented")
			}
		})
		return data;
	}
}
