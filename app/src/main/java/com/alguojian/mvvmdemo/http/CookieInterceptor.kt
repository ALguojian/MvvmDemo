package com.alguojian.mvvmdemo.http

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

import java.io.IOException

class CookieInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Cookie", "添加cookie")
        return chain.proceed(builder.build())
    }
}
