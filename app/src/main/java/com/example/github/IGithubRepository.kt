package com.example.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface IGithubRepository {
	fun getRepository(string: String) : LiveData<String>
}
