package com.exam.paper.data.di

import android.app.Application
import android.content.ComponentCallbacks2
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
        clearCache()
    }
    private fun clearCache(){
        cacheDir.deleteRecursively()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if(level==ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN){
            clearCache()
        }
    }
}