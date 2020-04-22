package com.example.github
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.internal.schedulers.IoScheduler
import io.reactivex.internal.schedulers.ScheduledRunnable
import io.reactivex.schedulers.Schedulers
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
			val repoName = githubRepositoryName.getRepository(name)
			repoName
			Log.d("network", repoName)
			repoString.postValue("")
			repoString.postValue(repoName)

		}
	}


	fun getRepoNameRX(name: String) {
		Log.d("network", "helell")
		githubRepositoryName.getRepositoryRX(name)
			.subscribeOn(Schedulers.io() )
			.subscribe { it ->
				Log.d("network", it.toString())
				repoString.postValue(it.toString())
			}


	}
}
