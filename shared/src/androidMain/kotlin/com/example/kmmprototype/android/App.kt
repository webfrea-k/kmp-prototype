package com.example.kmmprototype.android
import android.app.Application

class App: Application() {

    val global = Global

    override fun onCreate() {
        super.onCreate()
        global.prefs = getSharedPreferences("", MODE_PRIVATE)
    }
}