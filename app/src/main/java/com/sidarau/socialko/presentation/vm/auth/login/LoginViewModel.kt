package com.sidarau.socialko.presentation.vm.auth.login

import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import com.sidarau.socialko.domain.auth.UserInteractor
import com.sidarau.socialko.models.domain.user.AuthUser
import com.sidarau.socialko.models.presentation.Response
import com.sidarau.socialko.presentation.vm.core.BaseViewModel
import com.sidarau.socialko.presentation.vm.core.SingleLiveData
import io.reactivex.functions.Consumer

/**
 * @author Anton Sidorov
 */
class LoginViewModel(
        schedulers: SchedulersProvider,
        schedulerTransformers: RxSchedulerTransformers,
        private val userInteractor: UserInteractor
) : BaseViewModel(schedulers, schedulerTransformers) {

    val validateLiveData = SingleLiveData<List<String>>()
    val liveData = SingleLiveData<Response>()

    fun validate(email: String, password: String) {
        val user = AuthUser(email, password)
        userInteractor.validateLogin(user)
                .compose(schedulerTransformers.ioToUiTransformerSingle())
                .subscribe(Consumer { validateLiveData.setValue(it) })
                .connect()
    }

    fun login(email: String, password: String) {
        val user = AuthUser(email, password)
        userInteractor.login(user)
                .compose(schedulerTransformers.ioToUiTransformerMaybe())
                .doOnSubscribe({ liveData.setValue(Response.Progress(true)) })
                .doAfterTerminate({ liveData.setValue(Response.Progress(false)) })
                .subscribe(
                        { liveData.setValue(Response.Success(it)) },
                        { liveData.setValue(Response.Error(it)) })
                .connect()
    }
}