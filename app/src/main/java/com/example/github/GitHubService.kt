package com.example.github

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {


	@GET("search/")

	fun getRepo(@Query("q") name: String ): Call<String>;
}
