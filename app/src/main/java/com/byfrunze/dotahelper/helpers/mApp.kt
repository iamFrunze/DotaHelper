package com.byfrunze.dotahelper.helpers

import android.app.Application
import android.util.Log

class mApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("TAG", "Application!!")
    }
}