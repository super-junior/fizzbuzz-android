package com.example.github

import io.reactivex.Observable


class GithubRepository :
	IGithubRepository {

	override suspend fun getRepository(githubRepositoryName: String): String {
	   val githubHttpClient = GithubHttpClient()
		return githubHttpClient.retrieveRepo() //httpclient in
			.getRepo(githubRepositoryName)

	}

	fun getRepositoryRX(githubRepositoryName: String): Observable<String> {
		val githubHttpClient = GithubHttpClient()
		return githubHttpClient.retrieveRepo() //httpclient in
			  .getRepoRX(githubRepositoryName)
	}


}
