package com.sidarau.socialko.presentation.view.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection


/**
 *
 * @author Anton Sidorov
 */
abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutRes, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        observeLiveData()
    }

    protected abstract fun initViewModel()

    protected abstract fun observeLiveData()

    protected fun showProgressDialog(visible: Boolean) {
        if (!isAdded) return

        val fragment = childFragmentManager.findFragmentByTag(ProgressDialog.TAG)
        if (fragment != null && !visible) {
            (fragment as ProgressDialog).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && visible) {
            ProgressDialog().show(childFragmentManager, ProgressDialog.TAG)
            childFragmentManager.executePendingTransactions()
        }
    }

    protected fun showSnackMessage(message: String) {
        view?.let {
            val shackbar = Snackbar.make(it, message, Snackbar.LENGTH_LONG)
            shackbar.show()
        }
    }
}