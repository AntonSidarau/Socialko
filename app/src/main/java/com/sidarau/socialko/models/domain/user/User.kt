package com.sidarau.socialko.models.domain.user

/**
 * @author Anton Sidorov
 */
data class User(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
)