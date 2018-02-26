package com.sidarau.socialko.di.application.module

import com.sidarau.socialko.data.network.auth.AuthHolder
import com.sidarau.socialko.data.storage.AuthPreferences
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Module
interface CacheModule {

    @Singleton
    @Binds
    fun provideAuthHolder(authPreferences: AuthPreferences): AuthHolder
}