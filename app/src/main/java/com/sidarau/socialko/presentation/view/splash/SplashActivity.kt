package com.sidarau.socialko.presentation.view.splash

import android.os.Bundle
import android.os.Handler
import com.sidarau.socialko.R
import com.sidarau.socialko.core.extensions.postDelayed
import com.sidarau.socialko.presentation.BaseActivity
import com.sidarau.socialko.presentation.view.auth.AuthActivity

class SplashActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.splash_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed(2000) {
            startActivity(AuthActivity.newIntent(this))
        }
    }
}
