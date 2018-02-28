package com.sidarau.socialko.di.main

import dagger.Module

/**
 * @author Anton Sidorov
 */
@Module(includes = arrayOf(MainFragmentBuilderModule::class))
interface MainModule {
}