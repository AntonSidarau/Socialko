package com.sidarau.socialko.presentation.vm.auth.login

import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import com.sidarau.socialko.domain.auth.UserInteractor
import com.sidarau.socialko.presentation.vm.core.BaseViewModel

/**
 * @author Anton Sidorov
 */
class LoginViewModel(
        schedulers: SchedulersProvider,
        schedulerTransformers: RxSchedulerTransformers,
        private val userInteractor: UserInteractor
) : BaseViewModel(schedulers, schedulerTransformers) {

}