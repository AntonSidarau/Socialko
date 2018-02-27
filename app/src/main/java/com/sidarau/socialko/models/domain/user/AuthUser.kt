package com.sidarau.socialko.models.domain.user

import com.sidarau.socialko.core.Constants.Companion.EMPTY_STRING

/**
 * @author Anton Sidorov
 */
data class AuthUser constructor(
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
) {
    constructor(
            email: String,
            password: String
    ) : this(EMPTY_STRING, EMPTY_STRING, email, password)
}