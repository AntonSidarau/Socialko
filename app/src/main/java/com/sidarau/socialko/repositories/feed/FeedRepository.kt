package com.sidarau.socialko.repositories.feed


import com.sidarau.socialko.models.domain.feed.Post
import io.reactivex.Single

/**
 * @author Anton Sidorov
 */
interface FeedRepository {

    fun getPosts(): Single<List<Post>>
}