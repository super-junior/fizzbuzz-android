package com.example.fizzbuzz

import androidx.lifecycle.MutableLiveData

interface GithubRepository {
	fun getRepository(string: String) : MutableLiveData<String>
}
