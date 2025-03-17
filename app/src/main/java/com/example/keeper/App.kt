package com.example.keeper

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    private fun initRoomDatabase() {
        val scope = CoroutineScope(Dispatchers.IO)
    }
}