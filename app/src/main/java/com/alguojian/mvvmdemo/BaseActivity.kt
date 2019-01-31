package com.alguojian.mvvmdemo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.alguojian.mvvmdemo.viewmodel.BaseViewModel

/**
 * ${Descript}
 *
 * @author alguojian
 * @date 2019/1/31
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<T : BaseViewModel<*>> : AppCompatActivity() {

    lateinit var mContext: Context

    protected lateinit var mViewModel: T

    private lateinit var mBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = providers(this, ClassUtils.getInstance<Any>(this, 0) as Class<*>)
    }

    /**
     * 通过反射获得class对象，获得viewModel对象
     */
    private fun <T : ViewModel> providers(fragment: AppCompatActivity, modelClass: Class<*>): T {
        return ViewModelProviders.of(fragment).get<ViewModel>(modelClass as Class<ViewModel>) as T
    }

    abstract fun getLayoutId(): Int

    fun <T : ViewDataBinding> getBinding(): T = mBinding as T
}