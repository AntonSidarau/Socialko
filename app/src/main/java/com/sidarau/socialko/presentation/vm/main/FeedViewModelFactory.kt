package com.sidarau.socialko.presentation.vm.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.domain.feed.FeedInteractor
import com.sidarau.socialko.presentation.vm.auth.register.RegisterViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@FragmentScope
class FeedViewModelFactory @Inject constructor(
        private val schedulers: SchedulersProvider,
        private val schedulerTransformers: RxSchedulerTransformers,
        private val feedInteractor: FeedInteractor
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return FeedViewModel(schedulers, schedulerTransformers, feedInteractor) as (T)
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}