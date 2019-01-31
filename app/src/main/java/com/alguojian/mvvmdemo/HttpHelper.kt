package com.alguojian.mvvmdemo

import com.alguojian.mvvmdemo.http.CookieInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object HttpHelper {
    private var mRetrofit: Retrofit? = null
    private var builder: OkHttpClient.Builder? = null

    private const val HTTP_TIME = 10L

    init {
        //初始化OkHttpClient，设置参数
        builder = OkHttpClient().newBuilder()
        builder!!.readTimeout(HTTP_TIME, TimeUnit.SECONDS)
        builder!!.connectTimeout(HTTP_TIME, TimeUnit.SECONDS)

        //添加日志拦截器
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        TODO("待优化，判断开发模式才打印拦截，线上去除")
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

       // httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

        builder!!.addInterceptor(httpLoggingInterceptor)

        //添加cookie拦截器
        builder!!.addInterceptor(CookieInterceptor())
    }

    /**
     * 构造retrofit对象
     */
     fun initRetrofit(baseUrl: String) :HttpHelper{
        mRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(builder!!.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return this
    }

    fun <T> create(service: Class<T>): T {
        return mRetrofit!!.create(service)
    }
}
