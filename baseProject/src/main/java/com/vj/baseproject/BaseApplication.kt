/*

Copy right here
 */
package com.vj.baseproject

import android.app.Application

abstract class BaseApplication : Application() {
    companion object {
        lateinit var application: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    abstract fun logout()

}
