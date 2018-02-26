package com.sidarau.socialko.models.data.network.user

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @author Anton Sidorov
 */
class UserResponse(
        @SerializedName("avatar") val avatarUrl: String,
        @SerializedName("birthDate") val birthDate: Date,
        @SerializedName("created") val creationDate: Date,
        @SerializedName("email") val email: String,
        @SerializedName("firstName") val firstName: String,
        @SerializedName("friendOfMine") val friendOfMine: Boolean,
        @SerializedName("fullName") val fullName: String,
        @SerializedName("gender") val gender: String,
        @SerializedName("id") val id: Long,
        @SerializedName("lastName") val lastName: String,
        @SerializedName("myFriend") val myFriend: Boolean,
        @SerializedName("pageAvatar") val pageAvatarUrl: String,
        @SerializedName("phone") val phone: String,
        @SerializedName("shortName") val shortName: String
)