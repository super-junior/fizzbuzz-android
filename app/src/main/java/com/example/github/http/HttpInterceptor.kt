package com.example.github.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor {
	override fun intercept(chain: Interceptor.Chain): Response {
		val response = chain.proceed(chain.request())
		Log.d("network", chain.request().toString())
		return response
	}
}
