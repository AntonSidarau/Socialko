package com.sidarau.socialko.di.main

import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.presentation.view.main.feed.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Anton Sidorov
 */
@Module
interface MainFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(FeedModule::class))
    fun feedFragment(): FeedFragment
}