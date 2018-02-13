package com.sidarau.socialko.di.auth

import dagger.Module

/**
 * @author Anton Sidorov
 */
@Module(includes = arrayOf(AuthFragmentBuilderModule::class))
interface AuthModule {
}