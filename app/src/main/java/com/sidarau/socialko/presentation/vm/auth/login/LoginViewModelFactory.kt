package com.sidarau.socialko.presentation.vm.auth.login

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.domain.auth.UserInteractor
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@FragmentScope
class LoginViewModelFactory @Inject constructor(
        private val schedulers: SchedulersProvider,
        private val userInteractor: UserInteractor,
        private val schedulerTransformers: RxSchedulerTransformers
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(schedulers, schedulerTransformers, userInteractor) as (T)
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}