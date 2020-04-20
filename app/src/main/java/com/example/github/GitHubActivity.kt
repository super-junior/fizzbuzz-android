package com.example.github

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.fizzbuzz.R
import kotlinx.android.synthetic.main.github_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GitHubActivity: AppCompatActivity() {


	private val githubViewModel: GithubViewModel by viewModels()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.github_activity)

	    githubViewModel.repoString.observe(this, Observer{
			repo -> handleSuccessCall(repo)
		})

		github_button.setOnClickListener {
			lifecycleScope.launch {
				handleViewBeforeCall()
				getRepoName(github_input.text.toString())
			}
		}
	}

	suspend fun getRepoName(name: String) {
			 github_textview.text = ""
			 githubViewModel.getRepoName(name)

	}

	fun handleSuccessCall(repo: String){
		github_textview.text = repo
		scrollview.visibility = View.VISIBLE
		progressBar.visibility = View.INVISIBLE

	}
	fun handleViewBeforeCall(){
		scrollview.visibility = View.INVISIBLE
		progressBar.visibility= View.VISIBLE
	}
}
