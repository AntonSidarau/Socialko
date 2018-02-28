package com.sidarau.socialko.models.mappers

import com.sidarau.socialko.di.FragmentScope
import com.sidarau.socialko.models.data.network.feed.PostResponse
import com.sidarau.socialko.models.domain.feed.Post
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@FragmentScope
class PostMapper @Inject constructor() {

    fun postResponseToPost(from: PostResponse) =
            Post(from.avatarUrl, from.body, from.id, from.likes, from.personId,
                    from.personName, from.postDate)
}