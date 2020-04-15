package com.example.github
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GithubViewModel : ViewModel() {

	val repoString = MutableLiveData<String>();
   val githubRepositoryName =
	   GithubRepository()



	fun updaetName(name: String) {
	 // repoString.value = githubRepositoryName.getRepository(name).value
		repoString.value = name
	}


}
