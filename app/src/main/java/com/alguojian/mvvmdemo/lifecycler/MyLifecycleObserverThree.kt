package com.alguojian.mvvmdemo.lifecycler

import androidx.annotation.NonNull
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.GenericLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * 使用lifecycle的第三种方法为 直接实现DefaultLifecycleObserver
 *
 * 使用该方法需要添加依赖：implementation 'android.arch.lifecycle:common-java8:1.1.1'
 *
 * 使用java8，该方法作为优先选择，因为不需要再写其他注解等，，，，ø
 *
 * @author alguojian
 * @date 2019/1/29
 */
class MyLifecycleObserverThree : DefaultLifecycleObserver {

    override fun onCreate(@NonNull owner: LifecycleOwner) {
        println("使用lifecycle的第三种方法为 直接实现DefaultLifecycleObserver")
    }
}