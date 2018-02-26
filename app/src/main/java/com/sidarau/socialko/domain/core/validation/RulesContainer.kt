package com.sidarau.socialko.domain.core.validation

/**
 * @author Anton Sidorov
 */
interface RulesContainer {

    fun getRule(key: String): (String) -> Pair<Boolean, String>
}