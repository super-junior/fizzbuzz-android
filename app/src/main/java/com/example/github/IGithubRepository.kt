package com.example.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface IGithubRepository {
	suspend fun getRepository(string: String) : String
}
