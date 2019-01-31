package com.alguojian.mvvmdemo.repository

import com.alguojian.mvvmdemo.ApiService
import com.alguojian.mvvmdemo.HttpHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * 抽象类，用于获得数据传递给viewModel使用
 * 订阅以及取消订阅Rxjava
 *
 * @author alguojian
 * @date 2019/1/30
 */
abstract class BaseRepository {

    var mApiService: ApiService? = null

    private var mDisposables: CompositeDisposable? = null

    fun addSubscribe(vararg disposables: Disposable) {
        if (mDisposables == null) CompositeDisposable()

        for (disposable in disposables) {
            mDisposables!!.add(disposable)
        }
    }

    open fun unSubscribe() {
        mDisposables?.clear()
    }

    init {
        if (mApiService == null)
            mApiService =
                HttpHelper.initRetrofit("http://www.baidu.com/")
                    .create(ApiService::class.java)
    }
}
