package com.sidarau.socialko.data.network.auth

import com.sidarau.socialko.data.network.exception.AuthException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Singleton
class AuthorizationInterceptor @Inject constructor(
        private val authHolder: AuthHolder
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (request.header("No-Authentication") === null) {
            authHolder.token?.let {
                request.newBuilder()
                        .addHeader("Authorization", it)
                        .build()
            } ?: throw AuthException()
        }

        return chain.proceed(request)
    }
}