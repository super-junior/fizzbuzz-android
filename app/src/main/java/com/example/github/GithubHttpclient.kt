package com.example.github

import androidx.lifecycle.MutableLiveData
import retrofit2.*

class GithubHttpclient :
	IGithubHttpClient {

	override fun retrieveRepo(name: String): MutableLiveData<String> {
		val retrofit = Retrofit.Builder()
			.build()
		val githubService = retrofit.create(GitHubService::class.java)

		var data = MutableLiveData<String>()

		githubService.getRepo(name).enqueue(object : Callback<String> {
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

interface GithubHttpClient {
}
