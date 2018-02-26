package com.sidarau.socialko.repositories.auth

import com.sidarau.socialko.data.network.SocialkoApi
import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.models.data.network.user.UserResponse
import com.sidarau.socialko.models.domain.user.User
import com.sidarau.socialko.models.mappers.user.UserMapper
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class DefaultUserRepository @Inject constructor(
        private val api: SocialkoApi,
        private val mapper: UserMapper
) : UserRepository {

    override fun login(): Maybe<UserResponse> {
        throw UnsupportedOperationException()
    }

    override fun signUp(user: User): Completable {
        return api.signUp(mapper.userToUserRequest(user))
    }
}