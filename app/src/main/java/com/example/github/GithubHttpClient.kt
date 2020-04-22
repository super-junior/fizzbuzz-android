package com.example.github

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class GithubHttpClient : IGithubHttpClient {

	init {

	}
	override fun retrieveRepo(): GitHubService {

			val retrofit = Retrofit.Builder()
			.baseUrl("https://api.github.com")
			.addConverterFactory(ScalarsConverterFactory.create())
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.build()




		return retrofit.create(GitHubService::class.java)
	}
}
