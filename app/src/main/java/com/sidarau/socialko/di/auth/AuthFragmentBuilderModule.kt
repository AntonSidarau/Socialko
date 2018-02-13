package com.sidarau.socialko.di.auth

import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.presentation.view.auth.login.LoginFragment
import com.sidarau.socialko.presentation.view.auth.register.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Anton Sidorov
 */
@Module
interface AuthFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun loginFragment(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun registrationFragment(): RegistrationFragment

}