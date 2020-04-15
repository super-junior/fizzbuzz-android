package com.example.github

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {


	@GET("https://api.github.com/search/repositories?q={repositoryname}&sort=stars&order=desc")

	fun getRepo(@Path("repositoryname") name: String): Call<String>;
}
