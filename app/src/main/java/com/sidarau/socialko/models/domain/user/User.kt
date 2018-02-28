package com.sidarau.socialko.models.domain.user

/**
 * @author Anton Sidorov
 */
data class User(
        val avatarUrl: String,
        val birthDate: String?,
        val creationDate: Long,
        val email: String,
        val firstName: String,
        val friendOfMine: Boolean,
        val fullName: String,
        val gender: String,
        val id: Long,
        val lastName: String,
        val myFriend: Boolean,
        val pageAvatarUrl: String,
        val phone: String,
        val shortName: String
)