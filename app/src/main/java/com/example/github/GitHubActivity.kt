package com.example.github

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.R
import kotlinx.android.synthetic.main.github_activity.*
import kotlinx.coroutines.launch

import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubActivity: AppCompatActivity() {


	private val githubViewModel: GithubViewModel by viewModel()

	val fragmentmanager = supportFragmentManager
	val fragmentTransaction = fragmentmanager.beginTransaction()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.github_activity)
		val displayFragment = display()
		fragmentTransaction.add(R.id.fragment_container, displayFragment)
		fragmentTransaction.commit()

	}

}
