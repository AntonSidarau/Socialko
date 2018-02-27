package com.sidarau.socialko.domain.core.validation

import com.sidarau.socialko.core.Constants.Companion.EMPTY_STRING
import com.sidarau.socialko.di.ActivityScope
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class DefaultValidator @Inject constructor(
        private val rulesContainer: RulesContainer
) : Validator {

    private val fields: MutableMap<String, String> = HashMap()

    override fun addField(key: String, field: String?) {
        fields.put(key, field ?: EMPTY_STRING)
    }

    override fun validate(): Boolean {
        val results = getResults()

        return !results.any { !it.first }
    }

    override fun getResults(): List<Pair<Boolean, String>> {
        val validationResults: MutableList<Pair<Boolean, String>> = mutableListOf()
        for ((key, _) in fields) {
            validationResults.add(getResult(key))
        }

        return validationResults
    }

    override fun getResult(key: String): Pair<Boolean, String> {
        val field = fields[key]

        return field?.let {
            val rule = rulesContainer.getRule(key)
            rule(it)
        } ?: Pair(true, EMPTY_STRING)
    }
}