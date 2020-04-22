package com.example.github


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GitHubService {

	@GET("/search/repositories")
	suspend fun getRepo(@Query("q") name: String ): String;


	@GET("/search/repositories")
	fun getRepoRX(@Query("q") name: String ): Observable<String>

}
