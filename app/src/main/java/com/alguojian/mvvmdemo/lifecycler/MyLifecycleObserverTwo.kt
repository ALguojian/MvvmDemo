package com.alguojian.mvvmdemo.lifecycler

import androidx.lifecycle.GenericLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * 使用lifecycle的第二种方法为 直接继承GenericLifecycleObserver
 *
 * @author alguojian
 * @date 2019/1/29
 */
class MyLifecycleObserverTwo : GenericLifecycleObserver {
    override fun onStateChanged(source: LifecycleOwner?, event: Lifecycle.Event?) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                println("使用lifecycle的第二种方法为 直接继承GenericLifecycleObserver")
            }
            Lifecycle.Event.ON_START -> {
            }
            Lifecycle.Event.ON_DESTROY -> {
            }
            else -> {
            }
        }
    }
}