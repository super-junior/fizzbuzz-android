package com.example.github

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.github.http.HttpInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.time.Duration
import java.util.concurrent.TimeUnit

class GithubHttpClient : IGithubHttpClient {

	override suspend  fun retrieveRepo(): GitHubService {

		var httpClient =  OkHttpClient()
			.newBuilder()
			.addNetworkInterceptor(HttpInterceptor())


		val retrofit = Retrofit.Builder()
			.baseUrl("https://api.github.com")
			.client(httpClient.build())
			.addConverterFactory(ScalarsConverterFactory.create())
			.build()

		return retrofit.create(GitHubService::class.java)
	}
}
