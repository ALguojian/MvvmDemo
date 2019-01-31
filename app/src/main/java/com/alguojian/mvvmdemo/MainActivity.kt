package com.alguojian.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alguojian.mvvmdemo.lifecycler.MyLifecycleObserver
import com.alguojian.mvvmdemo.lifecycler.MyLifecycleObserverThree
import com.alguojian.mvvmdemo.lifecycler.MyLifecycleObserverTwo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyLifecycleObserver())
        lifecycle.addObserver(MyLifecycleObserverTwo())
        lifecycle.addObserver(MyLifecycleObserverThree())
    }
}
