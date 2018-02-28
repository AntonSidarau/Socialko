package com.sidarau.socialko.repositories.feed


import com.sidarau.socialko.data.network.SocialkoApi
import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.models.domain.feed.Post
import com.sidarau.socialko.models.mappers.PostMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@FragmentScope
class DefaultFeedRepository @Inject constructor(
        private val api: SocialkoApi,
        private val mapper: PostMapper
) : FeedRepository {

    override fun getPosts(): Single<List<Post>> {
        return api.getPosts()
                .flattenAsObservable { it }
                .map { mapper.postResponseToPost(it) }
                .toList()
    }
}