package com.sidarau.socialko.di.auth

import android.arch.lifecycle.ViewModelProvider
import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.presentation.vm.auth.register.RegisterViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * @author Anton Sidorov
 */
@Module
interface RegisterModule {

    @FragmentScope
    @Binds
    fun provideViewModelFactory(factory: RegisterViewModelFactory): ViewModelProvider.Factory
}