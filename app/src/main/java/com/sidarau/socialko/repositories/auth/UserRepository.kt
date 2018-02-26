package com.sidarau.socialko.repositories.auth

import com.sidarau.socialko.models.data.network.user.UserResponse
import com.sidarau.socialko.models.domain.user.User
import io.reactivex.Completable
import io.reactivex.Maybe

/**
 * @author Anton Sidorov
 */
interface UserRepository {

    fun signUp(user: User): Completable

    fun login(): Maybe<UserResponse>
}