package com.sidarau.socialko.models.data.network.feed

import com.google.gson.annotations.SerializedName

/**
 * @author Anton Sidorov
 */
data class PostResponse(
        @SerializedName("avatar") val avatarUrl: String,
        @SerializedName("body") val body: String,
        @SerializedName("id") val id: Long,
        @SerializedName("likes") val likes: Int,
        @SerializedName("person_id") val personId: Long,
        @SerializedName("person_name") val personName: String,
        @SerializedName("posted") val postDate: Long
)