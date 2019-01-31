package com.alguojian.mvvmdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.alguojian.mvvmdemo.ClassUtils
import com.alguojian.mvvmdemo.repository.BaseRepository

/**
 * ViewModel的基类，包含Repository的引用
 *
 * @author alguojian
 * @date 2019/1/30
 */
class BaseViewModel<T : BaseRepository>(application: Application) : AndroidViewModel(application) {

    /**
     * 根数据，未解析，使用liveData postValue()之后进行解析使用
     */
    var mutableLiveData: MutableLiveData<String> = MutableLiveData()

    /**
     * 获得数据
     */
    var mRepository: T? = null

    init {
        mRepository = ClassUtils.getNewInstance<T>(this, 0)
    }

    /**
     * viewModel关联生命周期，销毁时进行RxJava的解除订阅
     */
    override fun onCleared() {
        super.onCleared()
        mRepository?.unSubscribe()
    }
}
