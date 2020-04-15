package com.example.github
import androidx.lifecycle.ViewModel

class GithubViewModel : ViewModel() {

   val githubRepositoryName =
	   GithubRepository()
	val repositoryName = ""
	val user = githubRepositoryName.getRepository(repositoryName)

}
