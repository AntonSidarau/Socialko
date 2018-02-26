package com.sidarau.socialko.domain.core.validation

/**
 * @author Anton Sidorov
 */
interface Validator {

    fun addField(key: String, field: String)

    fun validate(): Boolean

    fun getResults(): List<Pair<Boolean, String>>

    fun getResult(key: String): Pair<Boolean, String>
}