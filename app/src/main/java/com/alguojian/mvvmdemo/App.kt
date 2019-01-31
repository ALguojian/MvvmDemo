package com.alguojian.mvvmdemo

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.socks.library.KLog
import kotlin.properties.Delegates

/**
 * 单例模式 启动类
 *
 * @author alguojian
 * @date 2019/1/31
 */
class App : Application(), Application.ActivityLifecycleCallbacks {

    private val TTAG = "asdfghjkl"

    companion object {
        var context: Context by Delegates.notNull()
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        KLog.init(true, TTAG)
        registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }
}