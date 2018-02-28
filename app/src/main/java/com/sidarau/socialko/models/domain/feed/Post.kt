package com.sidarau.socialko.models.domain.feed

/**
 * @author Anton Sidorov
 */
data class Post(
        val avatarUrl: String,
        val body: String,
        val id: Long,
        val likes: Int,
        val personId: Long,
        val personName: String,
        val postDate: Long
)