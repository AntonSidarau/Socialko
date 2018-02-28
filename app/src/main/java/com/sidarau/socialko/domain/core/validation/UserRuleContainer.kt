package com.sidarau.socialko.domain.core.validation

import com.sidarau.socialko.R
import com.sidarau.socialko.core.Constants.Companion.EMPTY_STRING
import com.sidarau.socialko.core.ResourceManager
import com.sidarau.socialko.di.ActivityScope
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * @author Anton Sidorov
 */
@ActivityScope
class UserRuleContainer @Inject constructor(
        private val resourceManager: ResourceManager
) : RulesContainer {

    private val container: MutableMap<String, (String) -> Pair<Boolean, String>> = mutableMapOf()

    init {
        container.put(FIRST_NAME) {
            if (it.isBlank() || it.length <= MIN_NAME_LENGTH) {
                Pair(false, resourceManager.getString(R.string.irregular_first_name))
            } else defaultPair
        }

        container.put(LAST_NAME) {
            if (it.isBlank() || it.length <= MIN_NAME_LENGTH) {
                Pair(false, resourceManager.getString(R.string.irregular_last_name))
            } else defaultPair
        }

        container.put(EMAIL) {
            if (it.isBlank() || !EMAIL_MATCHER.matcher(it).matches()) {
                Pair(false, resourceManager.getString(R.string.irregular_email))
            } else defaultPair
        }

        container.put(PASSWORD) {
            if (it.isBlank() || it.length <= MIN_PASSWORD_LENGTH) {
                Pair(false, resourceManager.getString(R.string.irregular_password))
            } else defaultPair
        }
    }

    override fun getRule(key: String): (String) -> Pair<Boolean, String> {
        return container[key]?.let { it } ?: defaultRule
    }

    companion object {

        const val FIRST_NAME = "firstName"
        const val LAST_NAME = "lastName"
        const val EMAIL = "email"
        const val PASSWORD = "password"

        const val MIN_NAME_LENGTH = 3
        const val MIN_PASSWORD_LENGTH = 4

        private val defaultPair = Pair(true, EMPTY_STRING)
        private val defaultRule: (String) -> Pair<Boolean, String> = { Pair(true, EMPTY_STRING) }

        private val EMAIL_MATCHER = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+")
    }
}