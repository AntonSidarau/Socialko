package com.sidarau.socialko.core.extensions

import android.content.SharedPreferences
import android.os.Handler
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
