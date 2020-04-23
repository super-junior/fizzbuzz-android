package com.example.github.koin

import com.example.github.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module{



	viewModel {
		GithubViewModel(get())
	}
	single<IGithubHttpClient>{
		GithubHttpClient()
	}
	single<IGithubRepository>{
		GithubRepository(get())
	}
}
