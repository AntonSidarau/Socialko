package com.sidarau.socialko.models.presentation

/**
 * @author Anton Sidorov
 */
sealed class Response {
    data class Error(val e: Throwable) : Response()
    data class Success<out T>(val body: T) : Response()
    data class Progress(val progress: Boolean = false) : Response()
}