package com.sidarau.socialko.di.auth

import android.arch.lifecycle.ViewModelProvider
import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.presentation.vm.auth.login.LoginViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * @author Anton Sidorov
 */
@Module
interface LoginModule {

    @FragmentScope
    @Binds
    fun provideViewModelFactory(factory: LoginViewModelFactory): ViewModelProvider.Factory
}