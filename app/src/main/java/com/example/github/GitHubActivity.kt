package com.example.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.R

import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubActivity: AppCompatActivity() {


	private val githubViewModel: GithubViewModel by viewModel()

	val fragmentmanager = supportFragmentManager
	val fragmentTransaction = fragmentmanager.beginTransaction()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.github_activity)
		val displayFragment = SearchResultListFragment()
		fragmentTransaction.add(R.id.fragment_container, displayFragment)
		fragmentTransaction.commit()

	}

}
