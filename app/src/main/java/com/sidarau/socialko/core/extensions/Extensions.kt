package com.sidarau.socialko.core.extensions

import android.content.SharedPreferences
import android.os.Handler

/**
 * @author Anton Sidorov
 */
inline fun <T : Any> Handler.postDelayed(
        delayMillis: Long,
        crossinline action: () -> T
): Boolean = postDelayed({ action() }, delayMillis)

inline fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    action(editor)
    editor.apply()
}