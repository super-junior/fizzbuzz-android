package com.example.github

class GithubRepository(private val githubHttpClient: IGithubHttpClient) : IGithubRepository {


	override suspend fun getRepository(githubRepositoryName: String): String {
		  return githubHttpClient.retrieveRepo().getRepo(githubRepositoryName)
	}

}
