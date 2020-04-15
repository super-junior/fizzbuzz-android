package com.example.github

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.example.fizzbuzz.R
import kotlinx.android.synthetic.main.github_activity.*

class GitHubActivity: AppCompatActivity() {


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.github_activity)

		val githubViewModel: GithubViewModel by viewModels()
	    githubViewModel.repoString.observe(this, Observer<String>{
			repo -> github_textview.text = repo.toString()
		})

		github_input.addTextChangedListener { newText  -> githubViewModel.updaetName(newText.toString()) }
	}
}
