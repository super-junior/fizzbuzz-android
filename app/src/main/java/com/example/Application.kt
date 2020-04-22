//package com.example
//
//import android.app.Application
//import com.example.github.IGithubHttpClient
//import org.koin.android.ext.koin.androidContext
//import org.koin.core.context.startKoin
//import org.koin.dsl.module
////
////class MyApplication : Application() {
////	override fun onCreate(){
//////		super.onCreate()
//////		// start Koin!
//////		startKoin {
//////			// declare used Android context
//////			androidContext(this@MyApplication)
//////			// declare modules
//////			modules(module {
//////				single { MyApplication(androidContext()) }
//////			})
//////		}
//////	}
////
////
////}
