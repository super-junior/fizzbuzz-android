package com.example.github

class GithubRepository :
	IGithubRepository {

	override suspend fun getRepository(githubRepositoryName: String): String {
	   val githubHttpClient = GithubHttpClient()
	   return githubHttpClient.retrieveRepo().getRepo(githubRepositoryName)
	}

}
