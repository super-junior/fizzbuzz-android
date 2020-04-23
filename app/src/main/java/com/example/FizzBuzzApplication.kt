package com.example

import android.app.Application
import com.example.github.koin.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FizzBuzzBaseApplication : Application() {
	override fun onCreate() {
		val moduleList = listOf(mainModule)
		super.onCreate()

		startKoin{
			androidLogger()
			androidContext(this@FizzBuzzBaseApplication)
			modules(moduleList)
		}
	}
}

