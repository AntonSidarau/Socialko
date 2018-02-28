package com.sidarau.socialko.models.mappers

import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.models.data.network.user.UserRequest
import com.sidarau.socialko.models.data.network.user.UserResponse
import com.sidarau.socialko.models.domain.user.AuthUser
import com.sidarau.socialko.models.domain.user.User
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class UserMapper @Inject constructor() {

    fun authUserToUserRequest(from: AuthUser) =
            UserRequest(from.firstName, from.lastName, from.email, from.password)

    fun userResponseToUser(from: UserResponse) =
            User(from.avatarUrl, from.birthDate, from.creationDate, from.email,
                    from.firstName, from.friendOfMine, from.fullName, from.gender,
                    from.id, from.lastName, from.myFriend, from.pageAvatarUrl,
                    from.phone, from.shortName)
}