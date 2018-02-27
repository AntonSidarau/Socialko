package com.sidarau.socialko.data.network.auth

import android.util.Base64
import com.sidarau.socialko.di.ActivityScope
import com.sidarau.socialko.models.domain.user.AuthUser
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class AuthEncoder @Inject constructor() {

    fun getEncodedData(user: AuthUser): String {
        val encodedData = Base64.encodeToString("${user.email}:${user.password}".toByteArray(),
                Base64.NO_WRAP)
        return String.format("Basic %s", encodedData)
    }
}