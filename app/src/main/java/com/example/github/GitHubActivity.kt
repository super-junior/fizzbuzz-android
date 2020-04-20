package com.example.github

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.fizzbuzz.R
import kotlinx.android.synthetic.main.github_activity.*
import kotlinx.coroutines.launch

class GitHubActivity: AppCompatActivity() {


	private val githubViewModel: GithubViewModel by viewModels()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.github_activity)

	    githubViewModel.repoString.observe(this, Observer<String>{
			repo -> github_textview.text = repo.toString()
		})

		github_button.setOnClickListener() {
			lifecycleScope.launch {
				getRepoName(github_input.text.toString())
			}
		}
	}

	suspend fun getRepoName(name: String) {
			 githubViewModel.getRepoName(name)
		    github_textview.text = ""
	}
}
