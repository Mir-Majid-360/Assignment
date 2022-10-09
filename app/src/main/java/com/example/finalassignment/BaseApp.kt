package com.example.finalassignment

import android.app.Application

class BaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        context =this
    }
    companion object{
        lateinit var context:BaseApp
    }
}