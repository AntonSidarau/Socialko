package com.sidarau.socialko.repositories.auth

import com.sidarau.socialko.data.network.SocialkoApi
import com.sidarau.socialko.data.network.auth.AuthHolder
import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.models.domain.user.AuthUser
import com.sidarau.socialko.models.domain.user.User
import com.sidarau.socialko.models.mappers.UserMapper
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class DefaultUserRepository @Inject constructor(
        private val authHolder: AuthHolder,
        private val api: SocialkoApi,
        private val mapper: UserMapper
) : UserRepository {

    override fun login(token: String): Maybe<User> {
        authHolder.token = token
        return api.login().map { mapper.userResponseToUser(it) }
    }

    override fun signUp(user: AuthUser): Completable {
        return api.signUp(mapper.authUserToUserRequest(user))
    }
}