package com.alguojian.mvvmdemo.lifecycler

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * lifeCycle的使用，之后可以让ViewModel使用该发方法，以便使用生命周期的方法
 *
 * lifecycle可以将lifecycleOwner对应的生命周期时间传递给内部的Lifecycle对象去处理，
 * 于是生命周期的改变就可以被lifecycle所注册的观察者LifecycleObserver观察到并触发其对应的事件
 *
 * @author alguojian
 * @date 2019/1/29
 */
class MyLifecycleObserver : LifecycleObserver {

    /**
     * 通过lifecycle的注解注入，将activity的生命周期同步与该方法
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        println("lifecycle的onCreate方法")
    }


    /**
     * 可以接受参数，第一个参数必须是LifecycleOwner
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(owner: LifecycleOwner) {
        println("lifecycle的ON_PAUSE方法")
    }


    /**
     * 使用any可以接受两个参数，第一个参数必须是LifecycleOwner，第二个是Lifecycle.Event)
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        println("lifecycle的ON_ANY方法")
    }
}