package me.tandeneck.tanutils

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        context = this

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    companion object {
        lateinit var context: Context
    }
}