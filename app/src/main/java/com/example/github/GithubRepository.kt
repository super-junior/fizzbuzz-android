package com.example.github

import androidx.lifecycle.LiveData

class GithubRepository :
	IGithubRepository {

	override fun getRepository(githubRepositoryName: String): LiveData<String> {
	   val githubHttpClient = Gi()
	   return githubHttpClient.retrieveRepo(githubRepositoryName)
	}

}
