package com.example.github

import androidx.lifecycle.MutableLiveData

interface IGithubHttpClient {

	suspend fun retrieveRepo(): GitHubService
}
