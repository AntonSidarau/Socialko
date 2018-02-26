package com.sidarau.socialko.presentation.vm.core

import android.arch.lifecycle.ViewModel
import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author Anton Sidorov
 */
open class BaseViewModel(
        protected val shedulers: SchedulersProvider,
        protected val schedulerTransformers: RxSchedulerTransformers
) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }

    protected fun Disposable.connect() = disposables.add(this)
}