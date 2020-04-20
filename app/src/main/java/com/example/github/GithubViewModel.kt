package com.example.github
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GithubViewModel : ViewModel() {

	val repoString = MutableLiveData<String>();
    val githubRepositoryName = GithubRepository()


	fun updaetName(name: String) {
			repoString.value = name
	}

   suspend fun getRepoName(name: String) {
	   viewModelScope.launch {
		   repoString.postValue("Loading...")
		   val repoName =  githubRepositoryName.getRepository(name)
		   Log.d("network", repoName)
		   repoString.postValue("")
		   repoString.postValue(repoName.removeSurrounding(""))

	   }
   }
}
