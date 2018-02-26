package com.sidarau.socialko.core.rx

import io.reactivex.Scheduler

/**
 * @author Anton Sidorov
 */
interface SchedulersProvider {

    fun ui(): Scheduler

    fun io(): Scheduler

    fun computation(): Scheduler

    fun newThread(): Scheduler

    fun trampoline(): Scheduler
}