package com.sidarau.socialko.di.application.component

import com.sidarau.socialko.AndroidApplication
import com.sidarau.socialko.di.application.module.ActivityBuilderModule
import com.sidarau.socialko.di.application.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class))
interface AppComponent : AndroidInjector<AndroidApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AndroidApplication>()
}