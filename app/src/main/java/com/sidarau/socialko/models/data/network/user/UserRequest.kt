package com.sidarau.socialko.models.data.network.user

import com.google.gson.annotations.SerializedName

/**
 * @author Anton Sidorov
 */
data class UserRequest(
        @SerializedName("firstName") val firstName: String,
        @SerializedName("lastName") val lastName: String,
        @SerializedName("userName") val login: String,
        @SerializedName("password") val password: String
)