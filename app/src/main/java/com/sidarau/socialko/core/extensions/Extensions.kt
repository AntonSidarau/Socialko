package com.sidarau.socialko.core.extensions

import android.os.Handler

/**
 * @author Anton Sidorov
 */
inline fun <T : Any> Handler.postDelayed(
        delayMillis: Long,
        crossinline action: () -> T
): Boolean = postDelayed({ action() }, delayMillis)