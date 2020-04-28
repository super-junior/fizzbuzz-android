package com.example.github
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GithubViewModel( private val githubRepositoryName  : IGithubRepository) : ViewModel() {

	val repoString: MutableLiveData<String> = MutableLiveData()


	fun updaetName(name: String) {
			repoString.value = name
	}

   suspend fun getRepoName(name: String) {
	   viewModelScope.launch {
		   val repoName =  githubRepositoryName.getRepository(name)

		   Log.d("network", repoName)
		   repoString.postValue(repoName.removeSurrounding(""))

	   }
   }
}
