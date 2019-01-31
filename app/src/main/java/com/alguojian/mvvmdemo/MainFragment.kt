package com.alguojian.mvvmdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alguojian.mvvmdemo.lifecycler.MyLifecycleObserverThree

/**
 * ${Descript}
 *
 * @author alguojian
 * @date 2019/1/29
 */
class MainFragment() : Fragment() {

    /**
     * fragment中使用需要在构造方法中进行注册
     */
    init {
        lifecycle.addObserver(MyLifecycleObserverThree())
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {
        val mainFragment=MainFragment()
        get() {
            mainFragment.arguments
            return field
        }
    }

}