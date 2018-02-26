package com.sidarau.socialko.di.application.module

import android.content.Context
import com.sidarau.socialko.AndroidApplication
import com.sidarau.socialko.core.rx.AppRxSchedulerTransformers
import com.sidarau.socialko.core.rx.AppSchedulers
import com.sidarau.socialko.core.rx.RxSchedulerTransformers
import com.sidarau.socialko.core.rx.SchedulersProvider
import com.sidarau.socialko.di.AppContext
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Module(includes = arrayOf(NetworkModule::class, CacheModule::class))
abstract class AppModule {

    @Singleton
    @AppContext
    @Binds
    abstract fun application(app: AndroidApplication): Context

    @Singleton
    @Binds
    abstract fun provideSchedulers(schedulers: AppSchedulers): SchedulersProvider

    @Singleton
    @Binds
    abstract fun provideTransformers(transformers: AppRxSchedulerTransformers): RxSchedulerTransformers
}