package com.example.github

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class GithubHttpClient : IGithubHttpClient {
	override suspend  fun retrieveRepo(): GitHubService {
//		val gson = GsonBuilder()
//			.registerTypeAdapter(GithubRepo::class.java, GithubRepo())
//			.create()

		val retrofit = Retrofit.Builder()
			.baseUrl("https://api.github.com")
			.addConverterFactory(ScalarsConverterFactory.create())
			.build()
		return retrofit.create(GitHubService::class.java)
	}
}
