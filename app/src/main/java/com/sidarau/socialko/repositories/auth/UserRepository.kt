package com.sidarau.socialko.repositories.auth

import com.sidarau.socialko.models.domain.user.AuthUser
import com.sidarau.socialko.models.domain.user.User
import io.reactivex.Completable
import io.reactivex.Maybe

/**
 * @author Anton Sidorov
 */
interface UserRepository {

    fun signUp(user: AuthUser): Completable

    fun login(token: String): Maybe<User>
}