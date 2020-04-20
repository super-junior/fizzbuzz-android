package com.example.github
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GithubViewModel : ViewModel() {

	val repoString = MutableLiveData<String>();
    val githubRepositoryName =
	   GithubRepository()



	fun updaetName(name: String) {
	 // repoString.value = githubRepositoryName.getRepository(name).value
		repoString.value = name
	}

   suspend fun getRepoName(name: String) {
	   viewModelScope.launch {
		   val repoName = githubRepositoryName.getRepository(name)
		   repoString.value = repoName.toString()
	   }
   }
}
