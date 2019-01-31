@file:Suppress("UNCHECKED_CAST")

package com.alguojian.mvvmdemo

import java.lang.reflect.ParameterizedType

/**
 * 通过反射获得类对象，后期可以改为dagger或者koni
 *
 * @author alguojian
 * @date 2019-01-30
 */
object ClassUtils {

    /**
     * 通过泛型会的类对象
     */
    fun <T> getNewInstance(any: Any?, i: Int): T? {
        if (any != null) {
            try {
                return ((any.javaClass
                    .genericSuperclass as ParameterizedType).actualTypeArguments[i] as Class<T>)
                    .newInstance()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: ClassCastException) {
                e.printStackTrace()
            }
        }
        return null

    }

    /**
     * 通过泛型得到类class
     */
    fun <T> getInstance(any: Any?, i: Int): T? {
        return if (any != null) {
            (any.javaClass
                .genericSuperclass as ParameterizedType)
                .actualTypeArguments[i] as T
        } else Unit as T
    }
}
