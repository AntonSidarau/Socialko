package com.sidarau.socialko.di.application.module

import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.di.auth.AuthModule
import com.sidarau.socialko.di.splash.SplashModule
import com.sidarau.socialko.presentation.view.auth.AuthActivity
import com.sidarau.socialko.presentation.view.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Anton Sidorov
 */
@Module
interface ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(AuthModule::class))
    fun authActivity(): AuthActivity
}