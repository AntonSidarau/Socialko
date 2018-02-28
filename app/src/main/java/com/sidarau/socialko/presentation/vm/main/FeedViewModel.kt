package com.sidarau.socialko.presentation.vm.main

import android.arch.lifecycle.MutableLiveData
import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import com.sidarau.socialko.domain.feed.FeedInteractor
import com.sidarau.socialko.models.presentation.Response
import com.sidarau.socialko.presentation.vm.core.BaseViewModel

/**
 * @author Anton Sidorov
 */
class FeedViewModel(
        schedulers: SchedulersProvider,
        schedulerTransformers: RxSchedulerTransformers,
        private val feedInteractor: FeedInteractor
) : BaseViewModel(schedulers, schedulerTransformers) {

    val liveData = MutableLiveData<Response>()

    fun fetchPosts() {
        feedInteractor.getPosts()
                .compose(schedulerTransformers.ioToUiTransformerSingle())
                .doOnSubscribe({ liveData.value = Response.Progress(true) })
                .doAfterTerminate({ liveData.value = Response.Progress(false) })
                .subscribe(
                        { liveData.value = Response.Success(it) },
                        { liveData.value = Response.Error(it) }
                )
    }
}