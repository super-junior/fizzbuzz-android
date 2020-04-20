package com.example.github

import GithubRepo
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class GithubRepoDeserializer : JsonDeserializer<GithubRepo> {
	override fun deserialize(
		json: JsonElement?,
		typeOfT: Type?,
		context: JsonDeserializationContext?
	): GithubRepo {
		TODO("Not yet implemented")
	}

}
