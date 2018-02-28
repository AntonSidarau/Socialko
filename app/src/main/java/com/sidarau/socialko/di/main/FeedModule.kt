package com.sidarau.socialko.di.main

import android.arch.lifecycle.ViewModelProvider
import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.presentation.vm.main.FeedViewModelFactory
import com.sidarau.socialko.repositories.feed.DefaultFeedRepository
import com.sidarau.socialko.repositories.feed.FeedRepository
import dagger.Binds
import dagger.Module

/**
 * @author Anton Sidorov
 */
@Module
interface FeedModule {

    @FragmentScope
    @Binds
    fun provideViewModelFactory(factory: FeedViewModelFactory): ViewModelProvider.Factory

    @FragmentScope
    @Binds
    fun provideFeedRepository(repository: DefaultFeedRepository): FeedRepository
}