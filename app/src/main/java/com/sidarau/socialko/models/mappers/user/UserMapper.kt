package com.sidarau.socialko.models.mappers.user

import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.models.data.network.user.UserRequest
import com.sidarau.socialko.models.domain.user.User
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class UserMapper @Inject constructor() {

    fun userToUserRequest(from: User) =
            UserRequest(from.firstName, from.lastName, from.email, from.password)
}