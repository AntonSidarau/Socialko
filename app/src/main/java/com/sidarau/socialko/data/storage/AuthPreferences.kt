package com.sidarau.socialko.data.storage

import android.content.Context
import com.sidarau.socialko.core.extensions.edit
import com.sidarau.socialko.data.network.auth.AuthHolder
import com.sidarau.socialko.di.AppContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Anton Sidorov
 */
@Singleton
class AuthPreferences @Inject constructor(
        @AppContext private val context: Context
) : AuthHolder {

    override var token: String?
        get() = getSharedPreferences(AUTH_PREFS).getString(KEY_TOKEN, null)
        set(value) {
            getSharedPreferences(AUTH_PREFS).edit {
                putString(KEY_TOKEN, value)
            }
        }

    private fun getSharedPreferences(prefsName: String) =
            context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)

    private companion object {
        private const val AUTH_PREFS = "auth_prefs"
        private const val KEY_TOKEN = "key_token"
    }
}