package com.example.github

import androidx.lifecycle.LiveData

class GithubRepository :
	IGithubRepository {

	override suspend fun getRepository(githubRepositoryName: String): String {
	   val githubHttpClient = GithubHttpClient()
	   return githubHttpClient.retrieveRepo().getRepo(githubRepositoryName)
	}

}
