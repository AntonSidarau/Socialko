package com.sidarau.socialko.data.network

import com.sidarau.socialko.models.data.network.feed.PostResponse
import com.sidarau.socialko.models.data.network.user.UserRequest
import com.sidarau.socialko.models.data.network.user.UserResponse
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * @author Anton Sidorov
 */
interface SocialkoApi {

    @POST("signUp")
    @Headers("No-Authentication: true")
    fun signUp(@Body user: UserRequest): Completable

    @GET("login")
    @Headers("Content-type: application/json")
    fun login(): Maybe<UserResponse>

    @GET("roll/all")
    @Headers("Content-type: application/json")
    fun getPosts(): Single<List<PostResponse>>
}