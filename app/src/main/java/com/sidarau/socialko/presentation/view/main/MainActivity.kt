package com.sidarau.socialko.presentation.view.main

import android.content.Context
import android.content.Intent
import com.sidarau.socialko.R
import com.sidarau.socialko.presentation.view.core.BaseActivity

/**
 * @author Anton Sidorov
 */
class MainActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.container_activity

    companion object {
        fun newIntent(context: Context) =
                Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
    }
}
