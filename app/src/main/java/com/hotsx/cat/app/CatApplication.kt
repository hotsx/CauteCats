package com.hotsx.cat.app

import android.app.Application
import kotlin.properties.Delegates

class CatApplication : Application() {
    companion object {
        var instance: CatApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}