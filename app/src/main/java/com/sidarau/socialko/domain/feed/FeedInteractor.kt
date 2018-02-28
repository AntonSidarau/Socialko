package com.sidarau.socialko.domain.feed

import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.models.domain.feed.Post
import com.sidarau.socialko.repositories.feed.FeedRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@FragmentScope
class FeedInteractor @Inject constructor(
        private val repository: FeedRepository
) {

    fun getPosts(): Single<List<Post>> = repository.getPosts()
}