package com.sidarau.socialko.di.application.module

import android.content.Context
import com.sidarau.socialko.AndroidApplication
import com.sidarau.socialko.di.AppContext
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Module
abstract class AppModule {

    @Singleton
    @AppContext
    @Binds
    abstract fun application(app: AndroidApplication): Context
}