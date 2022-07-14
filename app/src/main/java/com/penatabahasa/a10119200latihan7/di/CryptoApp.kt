package com.penatabahasa.a10119200latihan7.di

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@HiltAndroidApp
class CryptoApp : Application() {

    companion object {
        private lateinit var instance: CryptoApp
        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}