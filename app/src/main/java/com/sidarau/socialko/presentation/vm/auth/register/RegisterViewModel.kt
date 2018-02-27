package com.sidarau.socialko.presentation.vm.auth.register

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
class RegisterViewModel(
        schedulers: SchedulersProvider,
        schedulerTransformers: RxSchedulerTransformers,
        private val userInteractor: UserInteractor
) : BaseViewModel(schedulers, schedulerTransformers) {

    val liveData = SingleLiveData<Response>()
    val agreementLiveData = SingleLiveData<Boolean>()
    val validateLiveData = SingleLiveData<List<String>>()

    fun validate(firstName: String, lastName: String, email: String, password: String) {
        val user = AuthUser(firstName, lastName, email, password)
        userInteractor.validateRegister(user)
                .compose(schedulerTransformers.ioToUiTransformerSingle())
                .subscribe(Consumer { validateLiveData.setValue(it) })
                .connect()
    }

    fun register(
            firstName: String,
            lastName: String,
            email: String,
            password: String
    ) {
        val user = AuthUser(firstName, lastName, email, password)
        userInteractor.signUp(user)
                .compose(schedulerTransformers.ioToUiTransformerCompletable())
                .doOnSubscribe({ liveData.setValue(Response.Progress(true)) })
                .doAfterTerminate({ liveData.setValue(Response.Progress(false)) })
                .subscribe(
                        { liveData.setValue(Response.Success(Unit)) },
                        { liveData.setValue(Response.Error(it)) })
                .connect()
    }

}