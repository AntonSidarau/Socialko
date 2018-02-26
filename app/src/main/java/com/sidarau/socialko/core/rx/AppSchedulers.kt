package com.sidarau.socialko.core.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Singleton
class AppSchedulers @Inject constructor() : SchedulersProvider {
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun io() = Schedulers.io()

    override fun computation() = Schedulers.computation()

    override fun newThread() = Schedulers.newThread()

    override fun trampoline() = Schedulers.trampoline()
}