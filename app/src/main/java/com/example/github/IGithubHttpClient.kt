package com.example.github

import androidx.lifecycle.MutableLiveData

interface IGithubHttpClient {

	fun retrieveRepo(): GitHubService
}
